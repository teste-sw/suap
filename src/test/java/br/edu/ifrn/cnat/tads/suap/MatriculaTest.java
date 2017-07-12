package br.edu.ifrn.cnat.tads.suap;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertTrue;

public class MatriculaTest {

  @Test
  public void shouldReturnGivenValue() {
    IMatricula mock = mock(IMatricula.class);
    when(mock.test(1)).thenReturn(true);
    when(mock.test(2)).thenReturn(true);

    assertTrue(mock.test(1));
    assertTrue(mock.test(1));
  }
}
