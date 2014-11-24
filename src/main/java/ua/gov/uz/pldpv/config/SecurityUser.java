package ua.gov.uz.pldpv.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import ua.gov.uz.pldpv.entities.Company;
import ua.gov.uz.pldpv.entities.Role;
import ua.gov.uz.pldpv.entities.User;

public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 1L;

	public SecurityUser(User user) {
		if (user != null) {
			this.setId(user.getId());
			this.setUserName(user.getUserName());
			this.setCompany(user.getCompany());
			this.setPassword(user.getPassword());
			this.setRole(user.getRole());
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Role userRole = this.getRole();
		if (userRole != null) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
						userRole.getRoleName());
				authorities.add(authority);
			}
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public Company getCompany() {
		return super.getCompany();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}
}
