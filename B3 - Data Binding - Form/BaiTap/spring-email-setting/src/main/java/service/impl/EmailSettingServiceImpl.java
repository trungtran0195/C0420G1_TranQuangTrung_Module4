package service.impl;

import model.EmailSetting;
import repository.EmailSettingRepository;
import repository.EmailSettingRepositoryImpl;
import service.EmailSettingService;

import java.util.ArrayList;
import java.util.List;

public class EmailSettingServiceImpl implements EmailSettingService {

    EmailSettingRepository emailSettingRepository = new EmailSettingRepositoryImpl();

    @Override
    public List listLanguage() {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");

        return languages;
    }

    @Override
    public List pageSizes() {
        List<String> pagesize = new ArrayList<>();
        pagesize.add("5");
        pagesize.add("10");
        pagesize.add("15");
        pagesize.add("25");
        pagesize.add("50");
        pagesize.add("100");
        return pagesize;
    }

    @Override
    public List<EmailSetting> findAll() {
        return emailSettingRepository.findAll();
    }

    @Override
    public void save(EmailSetting student) {
        emailSettingRepository.save(student);
    }

    @Override
    public EmailSetting findById(int id) {
        return emailSettingRepository.findById(id);
    }
}
