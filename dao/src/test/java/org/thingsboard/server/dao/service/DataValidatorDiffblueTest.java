package org.thingsboard.server.dao.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.exception.DataValidationException;

public class DataValidatorDiffblueTest {
  /**
   * Test {@link DataValidator#validateEmail(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#validateEmail(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataValidator.validateEmail(String)"})
  public void testValidateEmail_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> DataValidator.validateEmail(null));
  }

  /**
   * Test {@link DataValidator#doValidateEmail(String)}.
   * <ul>
   *   <li>When {@code jane.doe@example.org}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#doValidateEmail(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataValidator.doValidateEmail(String)"})
  public void testDoValidateEmail_whenJaneDoeExampleOrg_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(DataValidator.doValidateEmail("jane.doe@example.org"));
  }

  /**
   * Test {@link DataValidator#doValidateEmail(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidator#doValidateEmail(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataValidator.doValidateEmail(String)"})
  public void testDoValidateEmail_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DataValidator.doValidateEmail(null));
  }
}
