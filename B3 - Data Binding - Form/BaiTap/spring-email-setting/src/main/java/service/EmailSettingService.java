package service;

import model.EmailSetting;

import java.util.List;

public interface EmailSettingService {
    List<EmailSetting> findAll();
    void save(EmailSetting student);
    EmailSetting findById(int id);
}
