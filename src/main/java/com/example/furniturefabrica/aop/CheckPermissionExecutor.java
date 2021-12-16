package com.example.furniturefabrica.aop;

import com.example.furniturefabrica.entity.User;
import com.example.furniturefabrica.exeptions.ForibiddenExeptions;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckPermissionExecutor {

    @Before(value = ("@annotation(huquqniTekshirish)"))
    public void chechPermissionMyMethod(CheckPermissions huquqniTekshirish) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean exist = false;
        for (GrantedAuthority authority : user.getAuthorities()) {
            if (authority.getAuthority().equals(huquqniTekshirish.huquq())) {
                exist = true;
                break;
            }
        }
        if (!exist)
            throw new ForibiddenExeptions(huquqniTekshirish.huquq(), "Sizga huquq yoq");


    }

}
