import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CampOrganisationTest {

    @Test
    public void shouldThrowExceptionWhenStudentFirstNameIsNull() {
        //given
        CampOrganisation campOrganisation = new CampOrganisation(new ArrayList<>());
        String newStudentLastName = "Nowak";

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> campOrganisation.addStudent(null, newStudentLastName));
    }

    @Test
    public void shouldThrowExceptionWhenStudentLastNameIsNull() {
        //given
        CampOrganisation campOrganisation = new CampOrganisation(new ArrayList<>());
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
}