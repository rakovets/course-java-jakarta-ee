package by.rakovets.course.java.jakarta_ee.jstl.service;


import by.rakovets.course.java.jakarta_ee.jstl.dao.AbilityDao;
import by.rakovets.course.java.jakarta_ee.jstl.entity.Ability;

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
