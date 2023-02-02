package mryw.exercises.springsecurity.registration;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public void create(Registration registration) {
        registrationRepository.save(registration);
    }

    public Registration findById(Long id) {
        return registrationRepository.findById(id).orElse(null);
    }

    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    public Registration approveRegistration(Long id, Boolean approved) {
        Optional<Registration> registrationOptional = registrationRepository.findById(id);

        if(registrationOptional.isPresent()){
            Registration registration = registrationOptional.get();
            registration.setApproved(approved);

            return registrationRepository.save(registration);
        }

        throw new EntityNotFoundException(("Didn't find post with id: " + id));
    }
}
