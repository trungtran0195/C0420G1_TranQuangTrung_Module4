package service.impl;

import model.EmailSetting;
import repository.EmailSettingRepository;
import repository.EmailSettingRepositoryImpl;
import service.EmailSettingService;

import java.util.List;

public class EmailSettingServiceImpl implements EmailSettingService {

    EmailSettingRepository emailSettingRepository = new EmailSettingRepositoryImpl();

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
