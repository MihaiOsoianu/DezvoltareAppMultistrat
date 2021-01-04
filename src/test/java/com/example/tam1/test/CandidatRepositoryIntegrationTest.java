//package com.example.tam1.test;
//
//import com.example.tam1.entity.Candidat;
//import com.example.tam1.repository.CandidatRepository;
//import com.example.tam1.service.CandidatService;
//import org.hamcrest.collection.IsEmptyCollection;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.not;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
////@ContextConfiguration(locations={"/appcontext/applicationContext.xml"})
//@DataJpaTest
//@ActiveProfiles("test")
//public class CandidatRepositoryIntegrationTest {
//
//    @MockBean
//    private CandidatRepository candidatRepository;
//
//    @MockBean
//    private CandidatService candidatService;
//
//    @Test
//    public void testAddNewCandidat() {
//        Candidat candidat = new Candidat();
//        candidat.setNume("Mada");
//        candidat.setPrenume("Sauciuc");
//        candidat.setEmail("mada@mail.ro");
//        candidat.setTelefon("0773465285");
//        candidatService.insertWithEntityManager(candidat);
//        List<Candidat> candidatList = candidatRepository.findAll();
//        assertThat(candidatList, not(IsEmptyCollection.empty()));
//    }
//}
