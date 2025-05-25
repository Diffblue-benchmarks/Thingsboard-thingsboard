package org.thingsboard.server.dao.attributes;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.dao.exception.IncorrectParameterException;

public class AttributeUtilsDiffblueTest {
  /**
   * Test {@link AttributeUtils#validate(AttributeKvEntry, boolean)} with {@code AttributeKvEntry}, {@code boolean}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeUtils#validate(AttributeKvEntry, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeUtils.validate(AttributeKvEntry, boolean)"})
  public void testValidateWithAttributeKvEntryBoolean_givenNull() {
    // Arrange
    AttributeKvEntry kvEntry = mock(AttributeKvEntry.class);
    when(kvEntry.getValue()).thenReturn("Value");
    when(kvEntry.getDataType()).thenReturn(null);
    when(kvEntry.getKey()).thenReturn("Key");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> AttributeUtils.validate(kvEntry, true));
    verify(kvEntry).getDataType();
    verify(kvEntry).getKey();
    verify(kvEntry).getValue();
  }

  /**
   * Test {@link AttributeUtils#validate(AttributeKvEntry, boolean)} with {@code AttributeKvEntry}, {@code boolean}.
   * <ul>
   *   <li>Then calls {@link AttributeKvEntry#getLastUpdateTs()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeUtils#validate(AttributeKvEntry, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeUtils.validate(AttributeKvEntry, boolean)"})
  public void testValidateWithAttributeKvEntryBoolean_thenCallsGetLastUpdateTs() {
    // Arrange
    AttributeKvEntry kvEntry = mock(AttributeKvEntry.class);
    when(kvEntry.getLastUpdateTs()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(kvEntry.getValue()).thenReturn("Value");
    when(kvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(kvEntry.getKey()).thenReturn("Key");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> AttributeUtils.validate(kvEntry, true));
    verify(kvEntry).getLastUpdateTs();
    verify(kvEntry).getDataType();
    verify(kvEntry, atLeast(1)).getKey();
    verify(kvEntry).getValue();
  }

  /**
   * Test {@link AttributeUtils#validate(List, boolean)} with {@code List}, {@code boolean}.
   * <ul>
   *   <li>Given {@link AttributeKvEntry} {@link KvEntry#getDataType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeUtils#validate(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeUtils.validate(List, boolean)"})
  public void testValidateWithListBoolean_givenAttributeKvEntryGetDataTypeReturnNull() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getValue()).thenReturn("Value");
    when(attributeKvEntry.getDataType()).thenReturn(null);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> kvEntries = new ArrayList<>();
    kvEntries.add(attributeKvEntry);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> AttributeUtils.validate(kvEntries, true));
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry).getValue();
  }

  /**
   * Test {@link AttributeUtils#validate(List, boolean)} with {@code List}, {@code boolean}.
   * <ul>
   *   <li>Then calls {@link AttributeKvEntry#getLastUpdateTs()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeUtils#validate(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeUtils.validate(List, boolean)"})
  public void testValidateWithListBoolean_thenCallsGetLastUpdateTs() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getLastUpdateTs()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(attributeKvEntry.getValue()).thenReturn("Value");
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> kvEntries = new ArrayList<>();
    kvEntries.add(attributeKvEntry);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> AttributeUtils.validate(kvEntries, true));
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry, atLeast(1)).getKey();
    verify(attributeKvEntry).getValue();
  }

  /**
   * Test {@link AttributeUtils#validate(List, boolean)} with {@code List}, {@code boolean}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link AttributeKvEntry#getLastUpdateTs()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeUtils#validate(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeUtils.validate(List, boolean)"})
  public void testValidateWithListBoolean_whenFalse_thenCallsGetLastUpdateTs() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getLastUpdateTs()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> kvEntries = new ArrayList<>();
    kvEntries.add(attributeKvEntry);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> AttributeUtils.validate(kvEntries, false));
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry, atLeast(1)).getKey();
  }
}
