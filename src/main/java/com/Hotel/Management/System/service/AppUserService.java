package com.Hotel.Management.System.service;

import com.Hotel.Management.System.entity.AppUser;
import com.Hotel.Management.System.payload.AppUserDto;
import com.Hotel.Management.System.payload.LoginDto;
import com.Hotel.Management.System.payload.TokenDto;
import com.Hotel.Management.System.repository.AppUserRepository;
import com.auth0.jwt.JWT;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppUserService {

    private AppUserRepository appUserRepository;
    private ModelMapper modelMapper;
    private JWTService jwtService;

    public AppUserService(AppUserRepository appUserRepository, ModelMapper modelMapper, JWTService jwtService) {
        this.appUserRepository = appUserRepository;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
    }

    //------------------------------ Mapping ----------------------------//

    AppUser mapToEntity(AppUserDto appUserDto){
        return modelMapper.map(appUserDto,AppUser.class);
    }
    AppUserDto mapToDto(AppUser appUser){
        return modelMapper.map(appUser , AppUserDto.class);
    }

    //------------------------------------ SignUp ------------------------------------//

    public boolean verifyEmail(AppUserDto appUserDto) {
      return appUserRepository.findByEmail(appUserDto.getEmail()).isPresent();
    }

    public boolean verifyUsername(AppUserDto appUserDto) {
       return appUserRepository.findByUsername(appUserDto.getUsername()).isPresent();
    }

    public boolean verifyMobile(AppUserDto appUserDto) {
       return appUserRepository.findByMobileNum(appUserDto.getMobileNum()).isPresent();
    }

    public AppUserDto saveOwnerDetails(AppUserDto appUserDto) {
        encrypt(appUserDto);
        appUserDto.setRole("ROLE_OWNER");
        AppUser appUser = mapToEntity(appUserDto);
        AppUser save = appUserRepository.save(appUser);
        AppUserDto appUserDto1 = mapToDto(save);
        return appUserDto1;
    }
    public void encrypt(AppUserDto appUserDto){
        appUserDto.setPassword(BCrypt.hashpw(appUserDto.getPassword(),BCrypt.gensalt(5)));
    }

    public AppUserDto saveUserDetails(AppUserDto appUserDto) {
        encrypt(appUserDto);
        appUserDto.setRole("ROLE_USER");
        AppUser appUser = mapToEntity(appUserDto);
        AppUser save = appUserRepository.save(appUser);
        AppUserDto appUserDto1 = mapToDto(save);
        return appUserDto1;
    }

    //-------------------------------------- SignIn ----------------------------------------//

    public String verifyLogin(LoginDto loginDto) {
        Optional<AppUser> opUsername = appUserRepository.findByUsername(loginDto.getUsername());
        if (opUsername.isPresent()) {
            AppUser appUser = opUsername.get();
            if (BCrypt.checkpw(loginDto.getPassword(), appUser.getPassword())) {
                // Generate Token
                return jwtService.generateToken(appUser.getUsername());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Object tokenNumber(String token) {
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);
        tokenDto.setType("JWT");
        return tokenDto;
    }

    // ------------------- GetUserDetails ------------------- //

    public AppUserDto findUsername(String username) {
        return mapToDto(appUserRepository.findByUsername(username).get());
    }
    public AppUserDto findEmail(String email) {
        return mapToDto(appUserRepository.findByEmail(email).get());
    }
    public List<AppUserDto> getAllUserDetails() {
        return appUserRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // ----------------------- Finder ----------------------- //

    public boolean findById(Long id) {
        return appUserRepository.findById(id).isPresent();
    }

    public boolean findByUsername(String username) {
        return appUserRepository.findByUsername(username).isPresent();
    }

    // ----------------------- Update ----------------------- //

    public AppUserDto updateUserById(Long id, AppUserDto appUserDto) {
        AppUser appUser = appUserRepository.findById(id).get();
        if (appUserDto.getPassword()!= null &&!appUserDto.getPassword().isEmpty()) {
            encrypt(appUserDto);
            appUser.setPassword(appUserDto.getPassword());
        } else {
            appUser.setPassword(appUser.getPassword());
        }
        appUser.setName(appUserDto.getName());
        appUser.setUsername(appUserDto.getUsername());
        appUser.setEmail(appUserDto.getEmail());
        appUser.setMobileNum(appUserDto.getMobileNum());
        appUser.setRole(appUser.getRole());
        return mapToDto(appUserRepository.save(appUser));
    }

    public AppUserDto updateUserByUsername(String username, AppUserDto appUserDto) {
        AppUser appUser = appUserRepository.findByUsername(username).get();
        if (appUserDto.getPassword()!= null &&!appUserDto.getPassword().isEmpty()) {
            encrypt(appUserDto);
            appUser.setPassword(appUserDto.getPassword());
        } else {
            appUser.setPassword(appUser.getPassword());
        }
        appUser.setName(appUserDto.getName());
        appUser.setUsername(appUserDto.getUsername());
        appUser.setEmail(appUserDto.getEmail());
        appUser.setMobileNum(appUserDto.getMobileNum());
        appUser.setRole(appUser.getRole());
        return mapToDto(appUserRepository.save(appUser));
    }

    // ----------------------- Delete ----------------------- //

    public void deleteUserById(Long id) {
        appUserRepository.deleteById(appUserRepository.findById(id).get().getId());
    }

    public void deleteUserByUsername(String username) {
        appUserRepository.deleteById(appUserRepository.findByUsername(username).get().getId());
    }
}


