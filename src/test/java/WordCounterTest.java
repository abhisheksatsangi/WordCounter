import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WordCounterTest {

    @Mock
    Translator translatorMock;
    @InjectMocks
    WordCounter wordCounter;
    @Test
    public void testAddWordOnce() {
        //  create mock
        when(translatorMock.translate("abc")).thenReturn("abc");
        wordCounter.addWord("abc");
        verify(translatorMock, times(1)).translate("abc");
        assertEquals(1,wordCounter.countWords("abc"));
    }

    @Test
    public void testAddSameWordTwice() {
        //  create mock
        when(translatorMock.translate("abc")).thenReturn("abc");
        when(translatorMock.translate("abc")).thenReturn("abc");
        wordCounter.addWord("abc");
        wordCounter.addWord("abc");
        verify(translatorMock, times(2)).translate("abc");
        assertEquals(2,wordCounter.countWords("abc"));
    }

    @Test
    public void testAddWordWithTranslation() {
        //  create mock
        when(translatorMock.translate("flor")).thenReturn("flower");
        when(translatorMock.translate("flower")).thenReturn("flower");
        wordCounter.addWord("flower");
        wordCounter.addWord("flor");
        verify(translatorMock, times(1)).translate("flower");
        verify(translatorMock, times(1)).translate("flor");
        assertEquals(2,wordCounter.countWords("flower"));
    }

    @Test
    public void testAddWordWithNumerics() {
        wordCounter.addWord("flower1");
        verify(translatorMock, times(0)).translate("flower1");
        assertEquals(0,wordCounter.countWords("flower1"));
    }

}
