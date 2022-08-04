//package com.codegym.casestudy.model;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class MyUserDetail implements UserDetails {
//    private AppUser appUser;
//
//    public MyUserDetail(AppUser appUser) {
//        this.appUser = appUser;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for (Role role: appUser.getRoles()) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return grantedAuthorities;
//    }
//
//
//    @Override
//    public String getPassword() {
//        return appUser.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return appUser.getUsername();
//    }
//
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//
//    @Override
//    public boolean isEnabled() {
//        return appUser.getEnable();
//    }
//}
