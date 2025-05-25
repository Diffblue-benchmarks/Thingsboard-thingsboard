package org.thingsboard.server.dao.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.query.EntityDataPageLink;
import org.thingsboard.server.dao.exception.IncorrectParameterException;

public class ValidatorDiffblueTest {
  /**
   * Test {@link Validator#validateEntityId(EntityId, Function)} with {@code entityId}, {@code errorMessageFunction}.
   * <p>
   * Method under test: {@link Validator#validateEntityId(EntityId, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateEntityId(EntityId, Function)"})
  public void testValidateEntityIdWithEntityIdErrorMessageFunction() {
    // Arrange
    Function<EntityId, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<EntityId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateEntityId(null, errorMessageFunction));
    verify(errorMessageFunction).apply(isNull());
  }

  /**
   * Test {@link Validator#validateEntityId(EntityId, Function)} with {@code entityId}, {@code errorMessageFunction}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateEntityId(EntityId, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateEntityId(EntityId, Function)"})
  public void testValidateEntityIdWithEntityIdErrorMessageFunction_givenApply_whenNull() {
    // Arrange
    Function<EntityId, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<EntityId>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateEntityId(null, errorMessageFunction));
    verify(errorMessageFunction).apply(isNull());
  }

  /**
   * Test {@link Validator#validateEntityId(EntityId, Function)} with {@code entityId}, {@code errorMessageFunction}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateEntityId(EntityId, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateEntityId(EntityId, Function)"})
  public void testValidateEntityIdWithEntityIdErrorMessageFunction_whenAlarmIdWithIdIsNull() {
    // Arrange
    AlarmId entityId = new AlarmId(null);
    Function<EntityId, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<EntityId>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateEntityId(entityId, errorMessageFunction));
    verify(errorMessageFunction).apply(isA(EntityId.class));
  }

  /**
   * Test {@link Validator#validateEntityId(EntityId, String)} with {@code entityId}, {@code errorMessage}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateEntityId(EntityId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateEntityId(EntityId, String)"})
  public void testValidateEntityIdWithEntityIdErrorMessage_whenAlarmIdWithIdIsNull() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> Validator.validateEntityId(new AlarmId(null), "An error occurred"));
  }

  /**
   * Test {@link Validator#validateEntityId(EntityId, String)} with {@code entityId}, {@code errorMessage}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateEntityId(EntityId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateEntityId(EntityId, String)"})
  public void testValidateEntityIdWithEntityIdErrorMessage_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateEntityId(null, "An error occurred"));
  }

  /**
   * Test {@link Validator#validateId(UUIDBased, Function)} with {@code UUIDBased}, {@code Function}.
   * <p>
   * Method under test: {@link Validator#validateId(UUIDBased, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateId(UUIDBased, Function)"})
  public void testValidateIdWithUUIDBasedFunction() {
    // Arrange
    Function<UUIDBased, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<UUIDBased>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateId((UUIDBased) null, errorMessageFunction));
    verify(errorMessageFunction).apply(isNull());
  }

  /**
   * Test {@link Validator#validateId(UUIDBased, Function)} with {@code UUIDBased}, {@code Function}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@link AdminSettingsId#AdminSettingsId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUIDBased, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateId(UUIDBased, Function)"})
  public void testValidateIdWithUUIDBasedFunction_givenApply_whenAdminSettingsIdWithIdIsNull() {
    // Arrange
    AdminSettingsId id = new AdminSettingsId(null);
    Function<UUIDBased, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<UUIDBased>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateId(id, errorMessageFunction));
    verify(errorMessageFunction).apply(isA(UUIDBased.class));
  }

  /**
   * Test {@link Validator#validateId(UUIDBased, Function)} with {@code UUIDBased}, {@code Function}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUIDBased, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateId(UUIDBased, Function)"})
  public void testValidateIdWithUUIDBasedFunction_givenApply_whenNull() {
    // Arrange
    Function<UUIDBased, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<UUIDBased>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateId((UUIDBased) null, errorMessageFunction));
    verify(errorMessageFunction).apply(isNull());
  }

  /**
   * Test {@link Validator#validateId(UUIDBased, String)} with {@code UUIDBased}, {@code String}.
   * <ul>
   *   <li>When {@link AdminSettingsId#AdminSettingsId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUIDBased, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateId(UUIDBased, String)"})
  public void testValidateIdWithUUIDBasedString_whenAdminSettingsIdWithIdIsNull() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> Validator.validateId(new AdminSettingsId(null), "An error occurred"));
  }

  /**
   * Test {@link Validator#validateId(UUIDBased, String)} with {@code UUIDBased}, {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUIDBased, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateId(UUIDBased, String)"})
  public void testValidateIdWithUUIDBasedString_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateId((UUIDBased) null, "An error occurred"));
  }

  /**
   * Test {@link Validator#validateId(UUID, Function)} with {@code UUID}, {@code Function}.
   * <p>
   * Method under test: {@link Validator#validateId(UUID, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateId(UUID, Function)"})
  public void testValidateIdWithUuidFunction() {
    // Arrange
    Function<UUID, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateId((UUID) null, errorMessageFunction));
    verify(errorMessageFunction).apply(isNull());
  }

  /**
   * Test {@link Validator#validateId(UUID, Function)} with {@code UUID}, {@code Function}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@code Apply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUID, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateId(UUID, Function)"})
  public void testValidateIdWithUuidFunction_givenApply_whenFunctionApplyReturnApply() {
    // Arrange
    Function<UUID, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<UUID>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateId((UUID) null, errorMessageFunction));
    verify(errorMessageFunction).apply(isNull());
  }

  /**
   * Test {@link Validator#validateId(UUID, String)} with {@code UUID}, {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUID, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateId(UUID, String)"})
  public void testValidateIdWithUuidString_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateId((UUID) null, "An error occurred"));
  }

  /**
   * Test {@link Validator#validateIds(List, String)} with {@code ids}, {@code errorMessage}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateIds(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateIds(List, String)"})
  public void testValidateIdsWithIdsErrorMessage_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<? extends UUIDBased> ids = new ArrayList<>();
    ids.add(null);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateIds(ids, "An error occurred"));
  }

  /**
   * Test {@link Validator#validateIds(List, String)} with {@code ids}, {@code errorMessage}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateIds(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateIds(List, String)"})
  public void testValidateIdsWithIdsErrorMessage_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> Validator.validateIds(new ArrayList<>(), "An error occurred"));
  }

  /**
   * Test {@link Validator#validateIds(List, String)} with {@code ids}, {@code errorMessage}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateIds(List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateIds(List, String)"})
  public void testValidateIdsWithIdsErrorMessage_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateIds(null, "An error occurred"));
  }

  /**
   * Test {@link Validator#validateEntityDataPageLink(EntityDataPageLink)}.
   * <ul>
   *   <li>Given minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateEntityDataPageLink(EntityDataPageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateEntityDataPageLink(EntityDataPageLink)"})
  public void testValidateEntityDataPageLink_givenMinusOne() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink();
    pageLink.setPageSize(1);
    pageLink.setPage(-1);
    pageLink.setSortOrder(null);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateEntityDataPageLink(pageLink));
  }

  /**
   * Test {@link Validator#validateEntityDataPageLink(EntityDataPageLink)}.
   * <ul>
   *   <li>When {@link EntityDataPageLink#EntityDataPageLink()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateEntityDataPageLink(EntityDataPageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateEntityDataPageLink(EntityDataPageLink)"})
  public void testValidateEntityDataPageLink_whenEntityDataPageLink() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> Validator.validateEntityDataPageLink(new EntityDataPageLink()));
  }

  /**
   * Test {@link Validator#validateEntityDataPageLink(EntityDataPageLink)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateEntityDataPageLink(EntityDataPageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.validateEntityDataPageLink(EntityDataPageLink)"})
  public void testValidateEntityDataPageLink_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateEntityDataPageLink(null));
  }

  /**
   * Test {@link Validator#isValidProperty(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#isValidProperty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Validator.isValidProperty(String)"})
  public void testIsValidProperty_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Validator.isValidProperty(""));
  }

  /**
   * Test {@link Validator#isValidProperty(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#isValidProperty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Validator.isValidProperty(String)"})
  public void testIsValidProperty_whenKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Validator.isValidProperty("Key"));
  }

  /**
   * Test {@link Validator#isValidProperty(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#isValidProperty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Validator.isValidProperty(String)"})
  public void testIsValidProperty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Validator.isValidProperty(null));
  }

  /**
   * Test {@link Validator#isValidProperty(String)}.
   * <ul>
   *   <li>When {@code ^[\p{L}0-9_-]+$}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#isValidProperty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Validator.isValidProperty(String)"})
  public void testIsValidProperty_whenPL09_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Validator.isValidProperty("^[\\p{L}0-9_-]+$"));
  }

  /**
   * Test {@link Validator#checkNotNull(Object, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#checkNotNull(Object, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Validator.checkNotNull(Object, String)"})
  public void testCheckNotNull_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.checkNotNull(null, "An error occurred"));
  }
}
