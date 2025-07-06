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
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.exception.IncorrectParameterException;

public class AttributeUtilsDiffblueTest {
  /**
   * Test {@link AttributeUtils#validate(AttributeKvEntry, boolean)} with {@code AttributeKvEntry},
   * {@code boolean}.
   *
   * <p>Method under test: {@link AttributeUtils#validate(AttributeKvEntry, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeUtils.validate(AttributeKvEntry, boolean)"})
  public void testValidateWithAttributeKvEntryBoolean() {
    // Arrange
    AttributeKvEntry kvEntry = mock(AttributeKvEntry.class);
    when(kvEntry.getLastUpdateTs()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(kvEntry.getValue()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
   * Test {@link AttributeUtils#validate(AttributeKvEntry, boolean)} with {@code AttributeKvEntry},
   * {@code boolean}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeUtils#validate(AttributeKvEntry, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeUtils.validate(AttributeKvEntry, boolean)"})
  public void testValidateWithAttributeKvEntryBoolean_givenNull() {
    // Arrange
    AttributeKvEntry kvEntry = mock(AttributeKvEntry.class);
    when(kvEntry.getValue()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(kvEntry.getDataType()).thenReturn(null);
    when(kvEntry.getKey()).thenReturn("Key");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> AttributeUtils.validate(kvEntry, true));
    verify(kvEntry).getDataType();
    verify(kvEntry).getKey();
    verify(kvEntry).getValue();
  }

  /**
   * Test {@link AttributeUtils#validate(AttributeKvEntry, boolean)} with {@code AttributeKvEntry},
   * {@code boolean}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link AttributeUtils#validate(AttributeKvEntry, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeUtils.validate(AttributeKvEntry, boolean)"})
  public void testValidateWithAttributeKvEntryBoolean_givenOne() {
    // Arrange
    AttributeKvEntry kvEntry = mock(AttributeKvEntry.class);
    when(kvEntry.getLastUpdateTs()).thenReturn(1L);
    when(kvEntry.getValue()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(kvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(kvEntry.getKey()).thenReturn("Key");

    // Act
    AttributeUtils.validate(kvEntry, true);

    // Assert
    verify(kvEntry).getLastUpdateTs();
    verify(kvEntry).getDataType();
    verify(kvEntry, atLeast(1)).getKey();
    verify(kvEntry).getValue();
  }

  /**
   * Test {@link AttributeUtils#validate(List, boolean)} with {@code List}, {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntry} {@link AttributeKvEntry#getDataType()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeUtils#validate(List, boolean)}
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
   *
   * <ul>
   *   <li>Then calls {@link AttributeKvEntry#getLastUpdateTs()}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeUtils#validate(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeUtils.validate(List, boolean)"})
  public void testValidateWithListBoolean_thenCallsGetLastUpdateTs() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getLastUpdateTs())
        .thenThrow(new IncorrectParameterException("An error occurred"));
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
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then calls {@link AttributeKvEntry#getLastUpdateTs()}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeUtils#validate(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AttributeUtils.validate(List, boolean)"})
  public void testValidateWithListBoolean_whenFalse_thenCallsGetLastUpdateTs() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getLastUpdateTs())
        .thenThrow(new IncorrectParameterException("An error occurred"));
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> kvEntries = new ArrayList<>();
    kvEntries.add(attributeKvEntry);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class, () -> AttributeUtils.validate(kvEntries, false));
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry, atLeast(1)).getKey();
  }
}
