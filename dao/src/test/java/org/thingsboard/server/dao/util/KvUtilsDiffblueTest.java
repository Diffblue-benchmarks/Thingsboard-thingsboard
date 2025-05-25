package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.IncorrectParameterException;

public class KvUtilsDiffblueTest {
  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code valueNoXssValidation}.
   * <p>
   * Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new JsonDataEntry("\u0000", "42"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> KvUtils.validate(tsKvEntries, true));
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code valueNoXssValidation}.
   * <p>
   * Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation2() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new JsonDataEntry(null, "42"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> KvUtils.validate(tsKvEntries, true));
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code valueNoXssValidation}.
   * <p>
   * Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation3() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new JsonDataEntry("", "42"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> KvUtils.validate(tsKvEntries, true));
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code valueNoXssValidation}.
   * <p>
   * Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation4() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(null);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> KvUtils.validate(tsKvEntries, true));
  }

  /**
   * Test {@link KvUtils#validate(KvEntry, boolean)} with {@code tsKvEntry}, {@code valueNoXssValidation}.
   * <p>
   * Method under test: {@link KvUtils#validate(KvEntry, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KvUtils.validate(KvEntry, boolean)"})
  public void testValidateWithTsKvEntryValueNoXssValidation() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> KvUtils.validate((KvEntry) null, false));
  }

  /**
   * Test {@link KvUtils#validate(KvEntry, boolean)} with {@code tsKvEntry}, {@code valueNoXssValidation}.
   * <p>
   * Method under test: {@link KvUtils#validate(KvEntry, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KvUtils.validate(KvEntry, boolean)"})
  public void testValidateWithTsKvEntryValueNoXssValidation2() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> KvUtils.validate(new JsonDataEntry(null, "42"), true));
  }

  /**
   * Test {@link KvUtils#validate(KvEntry, boolean)} with {@code tsKvEntry}, {@code valueNoXssValidation}.
   * <p>
   * Method under test: {@link KvUtils#validate(KvEntry, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KvUtils.validate(KvEntry, boolean)"})
  public void testValidateWithTsKvEntryValueNoXssValidation3() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> KvUtils.validate(new JsonDataEntry("", "42"), true));
  }
}
