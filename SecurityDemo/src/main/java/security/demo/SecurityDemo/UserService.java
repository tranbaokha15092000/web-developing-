package security.demo.SecurityDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ManagerRepository managerRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee user = employeeRepository.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException(s);
        }
        if(managerRepository.findById(user.getId()).isPresent())
            return new CustomUserDetails(user, "ROLE_MANAGER");
        return new CustomUserDetails(user,"ROLE_LECTURER");
    }

    public boolean checkLogin(Employee user) {
        if(user.getPassword().equals(employeeRepository.findByUsername(user.getUsername()).getPassword())){
            return true;
        }
        return false;
    }
}
