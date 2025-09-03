package cm.skysoft.Care_Health;

import cm.skysoft.Care_Health.Dao.MedecinRepository;
import cm.skysoft.Care_Health.Dao.RoleRepository;
import cm.skysoft.Care_Health.Dao.ServiceMedicalRepository;
import cm.skysoft.Care_Health.Dao.UserRepository;
import cm.skysoft.Care_Health.Entity.Medecin;
import cm.skysoft.Care_Health.Entity.Role;
import cm.skysoft.Care_Health.Entity.ServiceMedical;
import cm.skysoft.Care_Health.Entity.UserDomain;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor

public class CareHealthApplication implements CommandLineRunner {

	private final ServiceMedicalRepository serviceMedicalRepository;
	private final MedecinRepository medecinRepository;

	public static void main(String[] args) {
		SpringApplication.run(CareHealthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ServiceMedical serviceMedical = ServiceMedical.builder()
				.nom("pediatrie_")
				.build();
		this.serviceMedicalRepository.save(serviceMedical);


//
//		List<Medecin> serviceMedicalList = this.medecinRepository.findByServiceName("chirurgie");
//
//		System.out.println(serviceMedicalList);
//
//	Optional<ServiceMedical> serviceMedicalOptional = this.serviceMedicalRepository.findByNom("chirurgie");
//
//		System.out.println("Service médical trouvé : " + serviceMedical);
//
//		 Uncomment the following lines to test the findByNom method)
//



//		if(serviceMedicalOptional.isEmpty()) {
//			System.out.println("Aucun service médical trouvé avec ce nom.");
//		} else {
//			ServiceMedical serviceMedical4 =  serviceMedicalOptional.get();
//			System.out.println("Service médical trouvé : " + serviceMedical4);
//		}

//
//		ServiceMedical savedServiceMedical = this.serviceMedicalRepository.save(serviceMedical);
//
//
//		Medecin medecin = Medecin.builder()
//				.nom("Dr. Jean")
//				.specialite("Gastroentérologie")
//				.serviceMedical(savedServiceMedical)
//				.build();
//
//		Medecin medecin2 = Medecin.builder()
//				.nom("Dr. Marie")
//				.specialite("Cardiologie")
//				.serviceMedical(savedServiceMedical)
//				.build();
//
//		Medecin medecin3 = Medecin.builder()
//				.nom("Dr. Paul")
//				.specialite("Pédiatrie")
//				.serviceMedical(savedServiceMedical)
//				.build();
//
//		this.medecinRepository.saveAll(List.of(medecin, medecin2, medecin3));
//
//
//		System.out.println(this.medecinRepository.findAll());

	}

//	@Bean
	public CommandLineRunner test(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
		return args -> {

			Optional<UserDomain> userDomain = userRepository.findByUsername("admin@gmail.com");

//			if (userDomain.isEmpty()){
				UserDomain user = UserDomain.builder()
						.username("admin@gmail.com")
						.enabled(true)
						.roles(
								Set.of("ROLE_SUPER_ADMIN").stream().map(roleName -> {
									Role role = new Role(null, roleName);
									return roleRepository.save(role);
								}).collect(Collectors.toSet()))
						.password(passwordEncoder.encode("1234"))
						.build();
				userRepository.save(user);
//			}

		};
	}
}
