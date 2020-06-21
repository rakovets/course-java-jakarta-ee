package com.rakovets.course_java_enterprise.solution.jstl.service;


import com.rakovets.course_java_enterprise.solution.jstl.dao.AbilityDao;
import com.rakovets.course_java_enterprise.solution.jstl.entity.Ability;

import java.util.List;

public final class AbilityService {

    private static AbilityService INSTANCE = null;

    private AbilityService() {
    }

    public static AbilityService getInstance() {
        if (INSTANCE == null) {
            synchronized (AbilityService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AbilityService();
                }
            }
        }
        return INSTANCE;
    }

    public List<Ability> getAllAbilities() {
        return AbilityDao.getInstance().findAll();
    }
}
