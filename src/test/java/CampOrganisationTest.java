import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CampOrganisationTest {

    @Mock
    private CampOrganisation campOrganisation;

    @BeforeEach
    public void setUp() {
        campOrganisation = new CampOrganisation(new ArrayList<>());
    }

//    @Test
//    public void shouldThrowExceptionWhenStudentFirstNameIsNull() {
//        //given
//        String newStudentLastName = "Nowak";
//
//        //when then
//        Assertions.assertThrows(IllegalArgumentException.class, () -> campOrganisation.addStudent(null, newStudentLastName));
//    }

//    @Test
//    public void shouldThrowExceptionWhenStudentLastNameIsNull() {
//        //given
//        String newStudentFirstName = "Basia";
//
//        //when then
//        Assertions.assertThrows(IllegalArgumentException.class, () -> campOrganisation.addStudent(newStudentFirstName, null));
//    }

    public static final String ANY_NAME = "Basia";
    public static final String ANY_SURNAME = "Nowak";

    private static Stream<Arguments> allNullExamples() {
        return Stream.of(
                Arguments.of(null, ANY_SURNAME),
                Arguments.of(ANY_NAME, null),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("allNullExamples")
    public void shouldThrowExceptionWhenStudentAnyNameIsNull(String firstName, String lastName) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> campOrganisation.addStudent(firstName, lastName));
    }

    @Test
    public void shouldReturnFalseIfNameExists() {
        //given
        CampOrganisation campOrganisation = new CampOrganisation(List.of("Basia Nowak"));

        //when
        boolean actual = campOrganisation.addStudent(ANY_NAME, ANY_SURNAME);

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