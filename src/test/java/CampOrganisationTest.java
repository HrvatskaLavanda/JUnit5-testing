import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CampOrganisationTest {

    @Mock
    private CampOrganisation campOrganisation;

    @BeforeEach
    public void setUp() {
        campOrganisation = new CampOrganisation(new ArrayList<>());
    }

    @Test
    public void shouldThrowExceptionWhenStudentFirstNameIsNull() {
        //given
        String newStudentLastName = "Nowak";

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> campOrganisation.addStudent(null, newStudentLastName));
    }

    @Test
    public void shouldThrowExceptionWhenStudentLastNameIsNull() {
        //given
        String newStudentFirstName = "Basia";

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> campOrganisation.addStudent(newStudentFirstName, null));
    }

    @Test
    public void shouldReturnFalseIfNameExists() {
        //given
        CampOrganisation campOrganisation = new CampOrganisation(List.of("Basia Nowak"));
        String newStudentFirstName = "Basia";
        String newStudentLastName = "Nowak";

        //when
        boolean actual = campOrganisation.addStudent(newStudentFirstName, newStudentLastName);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueWhenAddingNewStudent() {
        //given
        List<String> students = new ArrayList<>();
        students.add("Basia Nowak");
        CampOrganisation campOrganisation = new CampOrganisation(students);
        String newStudentFirstName = "Jan";
        String newStudentLastName = "Kowalski";

        //when
        boolean actual = campOrganisation.addStudent(newStudentFirstName, newStudentLastName);

        //then
        Assertions.assertTrue(actual);
    }
}