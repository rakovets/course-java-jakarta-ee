package by.rakovets.course.java.jakarta_ee.jstl.service;


import by.rakovets.course.java.jakarta_ee.jstl.dao.HeroDao;
import by.rakovets.course.java.jakarta_ee.jstl.dto.CreateNewHeroDto;
import by.rakovets.course.java.jakarta_ee.jstl.dto.ViewHeroBasicInfoDto;
import by.rakovets.course.java.jakarta_ee.jstl.dto.ViewHeroFullInfoDto;
import by.rakovets.course.java.jakarta_ee.jstl.entity.Hero;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public final class HeroService {
    private static HeroService INSTANCE = null;

    private HeroService() {
    }

    public static HeroService getInstance() {
        if (INSTANCE == null) {
            synchronized (HeroService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HeroService();
                }
            }
        }
        return INSTANCE;
    }

    public List<ViewHeroBasicInfoDto> getAllHeroes() {
        return HeroDao.getInstance().findAll().stream()
                .map(heroEntity -> new ViewHeroBasicInfoDto(heroEntity.getId(), heroEntity.getName()))
                .collect(Collectors.toList());
    }

    public void createNewHero(CreateNewHeroDto dto) {
        HeroDao.getInstance().create(new Hero(dto.getName(), dto.getIdentity(), dto.getAge(), dto.getGender()), dto.getAbilityId());
    }

    public ViewHeroFullInfoDto getFullInfo(long id) {
        Optional<Hero> heroOptional = HeroDao.getInstance().findById(id);
        if (!heroOptional.isPresent()) {
            throw new IllegalArgumentException("No hero with provided id!");
        }
        Hero hero = heroOptional.get();
        return new ViewHeroFullInfoDto(hero.getName(), hero.getIdentity(), hero.getGender().toString(),
                hero.getAge(), hero.getAbility().getName());
    }
}
