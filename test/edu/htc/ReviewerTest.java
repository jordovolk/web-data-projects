package edu.htc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by volkg_000 on 4/19/2016.
 */
public class ReviewerTest {
    @Test
    public void setReviewerName() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();

        reviewer.setName("jlv");
        assertEquals("jlv",reviewer.getName());
    }

    @Rule
    public final ExpectedException InvalidReviewerNameexception = ExpectedException.none();
    @Test(expected = InvalidDataException.class)
    public void setReviewerNameInvalidData() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setName("j1");
        InvalidReviewerNameexception.expect(InvalidDataException.class);
    }

    @Rule
    public final ExpectedException EmptyReviewerNameexception = ExpectedException.none();
    @Test(expected = InvalidDataException.class)
    public void setReviewerNameNull() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setName("");
        EmptyReviewerNameexception.expect(InvalidDataException.class);
    }

    @Rule
    public final ExpectedException InvalidReviewerAgeexception = ExpectedException.none();
    @Test(expected = InvalidDataException.class)
    public void setReviewerAgeInvalidData() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setAge(-1);
        InvalidReviewerAgeexception.expect(InvalidDataException.class);
    }


    @Test
    public void setReviewerAge() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setAge(10);
        assertEquals(10,reviewer.getAge());
    }

    @Rule
    public final ExpectedException EmptyReviewerGenderexception = ExpectedException.none();
    @Test(expected = InvalidDataException.class)
    public void setNullReviewer() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setGender("");

        EmptyReviewerGenderexception.expect(InvalidDataException.class);
    }

    @Rule
    public final ExpectedException InvalidReviewerGenderexception = ExpectedException.none();
    @Test(expected = InvalidDataException.class)
    public void setReviewerGenderInvalidData() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setGender("fem");
        InvalidReviewerGenderexception.expect(InvalidDataException.class);
    }

    @Test
    public void setReviewerGenderCorrectData() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setGender("Female");
        assertEquals("Female",reviewer.getGender());

        Reviewer reviewer2 = new Reviewer();
        reviewer2.setGender("male");
        assertEquals("male",reviewer2.getGender());
    }

    @Test
    public void setReviewerPasswordCorrectData() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setPassword("12345");
        assertEquals("12345", reviewer.getPassword());
    }

    @Rule
    public final ExpectedException InvalidReviewerPasswordexception = ExpectedException.none();
    @Test(expected = InvalidDataException.class)
    public void setReviewerPasswordInvalidData() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setPassword("1234");
        InvalidReviewerPasswordexception.expect(InvalidDataException.class);

    }




    @Rule
    public final ExpectedException EmptyReviewerPasswordexception = ExpectedException.none();
    @Test(expected = InvalidDataException.class)
    public void setEmptyReviewerPassword() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setPassword("");
        EmptyReviewerPasswordexception.expect(InvalidDataException.class);

    }

    @Test
    public void addGamefromEmpty() throws InvalidDataException {
        Game game = new Game();
        game.setName("Runescape");
        game.setAvgRating(4);
        Reviewer reviewer = new Reviewer();
        reviewer.addGame(game);

        assertEquals(1, reviewer.getFavoriteGames().size());
        assertEquals(game.getName(), reviewer.getFavoriteGames().get(0).getName());


    }

    @Test
    public void validateReviewerFields() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setName("Jordan");
        reviewer.setPassword("jordov");
        reviewer.setGender("Male");
        reviewer.setAge(19);



        assertEquals(true, reviewer.validateReviewer());
    }
    @Test
    public void validateReviewerFieldsMissingField() throws InvalidDataException {
        Reviewer reviewer = new Reviewer();
        reviewer.setName("Jordan");
        reviewer.setPassword("jordov");
        reviewer.setGender("Male");

        assertEquals(false, reviewer.validateReviewer());
    }







}
