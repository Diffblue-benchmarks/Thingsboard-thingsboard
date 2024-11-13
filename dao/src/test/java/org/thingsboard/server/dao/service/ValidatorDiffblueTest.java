package org.thingsboard.server.dao.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.query.EntityDataPageLink;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.IncorrectParameterException;

public class ValidatorDiffblueTest {
  /**
   * Test {@link Validator#validateEntityId(EntityId, Function)} with
   * {@code entityId}, {@code errorMessageFunction}.
   * <p>
   * Method under test: {@link Validator#validateEntityId(EntityId, Function)}
   */
  @Test
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
   * Test {@link Validator#validateEntityId(EntityId, Function)} with
   * {@code entityId}, {@code errorMessageFunction}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateEntityId(EntityId, Function)}
   */
  @Test
  public void testValidateEntityIdWithEntityIdErrorMessageFunction_givenApply_whenNull() {
    // Arrange
    Function<EntityId, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<EntityId>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateEntityId(null, errorMessageFunction));
    verify(errorMessageFunction).apply(isNull());
  }

  /**
   * Test {@link Validator#validateEntityId(EntityId, Function)} with
   * {@code entityId}, {@code errorMessageFunction}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateEntityId(EntityId, Function)}
   */
  @Test
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
   * Test {@link Validator#validateEntityId(EntityId, String)} with
   * {@code entityId}, {@code errorMessage}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateEntityId(EntityId, String)}
   */
  @Test
  public void testValidateEntityIdWithEntityIdErrorMessage_whenAlarmIdWithIdIsNull() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> Validator.validateEntityId(new AlarmId(null), "An error occurred"));
  }

  /**
   * Test {@link Validator#validateEntityId(EntityId, String)} with
   * {@code entityId}, {@code errorMessage}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateEntityId(EntityId, String)}
   */
  @Test
  public void testValidateEntityIdWithEntityIdErrorMessage_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateEntityId(null, "An error occurred"));
  }

  /**
   * Test {@link Validator#validateString(String, Function)} with {@code val},
   * {@code errorMessageFunction}.
   * <p>
   * Method under test: {@link Validator#validateString(String, Function)}
   */
  @Test
  public void testValidateStringWithValErrorMessageFunction() {
    // Arrange
    Function<String, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateString(null, errorMessageFunction));
    verify(errorMessageFunction).apply(isNull());
  }

  /**
   * Test {@link Validator#validateString(String, Function)} with {@code val},
   * {@code errorMessageFunction}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateString(String, Function)}
   */
  @Test
  public void testValidateStringWithValErrorMessageFunction_givenApply_whenEmptyString() {
    // Arrange
    Function<String, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateString("", errorMessageFunction));
    verify(errorMessageFunction).apply(eq(""));
  }

  /**
   * Test {@link Validator#validateString(String, Function)} with {@code val},
   * {@code errorMessageFunction}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateString(String, Function)}
   */
  @Test
  public void testValidateStringWithValErrorMessageFunction_givenApply_whenNull() {
    // Arrange
    Function<String, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateString(null, errorMessageFunction));
    verify(errorMessageFunction).apply(isNull());
  }

  /**
   * Test {@link Validator#validateString(String, String)} with {@code val},
   * {@code errorMessage}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateString(String, String)}
   */
  @Test
  public void testValidateStringWithValErrorMessage_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateString("", "An error occurred"));
  }

  /**
   * Test {@link Validator#validateString(String, String)} with {@code val},
   * {@code errorMessage}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateString(String, String)}
   */
  @Test
  public void testValidateStringWithValErrorMessage_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateString(null, "An error occurred"));
  }

  /**
   * Test {@link Validator#validatePositiveNumber(long, String)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validatePositiveNumber(long, String)}
   */
  @Test
  public void testValidatePositiveNumber_whenZero_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validatePositiveNumber(0L, "An error occurred"));
  }

  /**
   * Test {@link Validator#validateId(UUIDBased, Function)} with
   * {@code UUIDBased}, {@code Function}.
   * <p>
   * Method under test: {@link Validator#validateId(UUIDBased, Function)}
   */
  @Test
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
   * Test {@link Validator#validateId(UUIDBased, Function)} with
   * {@code UUIDBased}, {@code Function}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@link AdminSettingsId#AdminSettingsId(UUID)} with id is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUIDBased, Function)}
   */
  @Test
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
   * Test {@link Validator#validateId(UUIDBased, Function)} with
   * {@code UUIDBased}, {@code Function}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUIDBased, Function)}
   */
  @Test
  public void testValidateIdWithUUIDBasedFunction_givenApply_whenNull() {
    // Arrange
    Function<UUIDBased, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<UUIDBased>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateId((UUIDBased) null, errorMessageFunction));
    verify(errorMessageFunction).apply(isNull());
  }

  /**
   * Test {@link Validator#validateId(UUIDBased, String)} with {@code UUIDBased},
   * {@code String}.
   * <ul>
   *   <li>When {@link AdminSettingsId#AdminSettingsId(UUID)} with id is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUIDBased, String)}
   */
  @Test
  public void testValidateIdWithUUIDBasedString_whenAdminSettingsIdWithIdIsNull() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> Validator.validateId(new AdminSettingsId(null), "An error occurred"));
  }

  /**
   * Test {@link Validator#validateId(UUIDBased, String)} with {@code UUIDBased},
   * {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUIDBased, String)}
   */
  @Test
  public void testValidateIdWithUUIDBasedString_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateId((UUIDBased) null, "An error occurred"));
  }

  /**
   * Test {@link Validator#validateId(UUID, Function)} with {@code UUID},
   * {@code Function}.
   * <p>
   * Method under test: {@link Validator#validateId(UUID, Function)}
   */
  @Test
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
   * Test {@link Validator#validateId(UUID, Function)} with {@code UUID},
   * {@code Function}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@link Function} {@link Function#apply(Object)} return
   * {@code Apply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUID, Function)}
   */
  @Test
  public void testValidateIdWithUuidFunction_givenApply_whenFunctionApplyReturnApply() {
    // Arrange
    Function<UUID, String> errorMessageFunction = mock(Function.class);
    when(errorMessageFunction.apply(Mockito.<UUID>any())).thenReturn("Apply");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateId((UUID) null, errorMessageFunction));
    verify(errorMessageFunction).apply(isNull());
  }

  /**
   * Test {@link Validator#validateId(UUID, String)} with {@code UUID},
   * {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateId(UUID, String)}
   */
  @Test
  public void testValidateIdWithUuidString_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateId((UUID) null, "An error occurred"));
  }

  /**
   * Test {@link Validator#validateIds(List, String)} with {@code ids},
   * {@code errorMessage}.
   * <ul>
   *   <li>Given {@link AdminSettingsId#AdminSettingsId(UUID)} with id is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateIds(List, String)}
   */
  @Test
  public void testValidateIdsWithIdsErrorMessage_givenAdminSettingsIdWithIdIsNull() {
    // Arrange
    ArrayList<UUIDBased> ids = new ArrayList<>();
    ids.add(new AdminSettingsId(null));
    ids.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateIds(ids, "An error occurred"));
  }

  /**
   * Test {@link Validator#validateIds(List, String)} with {@code ids},
   * {@code errorMessage}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateIds(List, String)}
   */
  @Test
  public void testValidateIdsWithIdsErrorMessage_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<? extends UUIDBased> ids = new ArrayList<>();
    ids.add(null);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateIds(ids, "An error occurred"));
  }

  /**
   * Test {@link Validator#validateIds(List, String)} with {@code ids},
   * {@code errorMessage}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateIds(List, String)}
   */
  @Test
  public void testValidateIdsWithIdsErrorMessage_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> Validator.validateIds(new ArrayList<>(), "An error occurred"));
  }

  /**
   * Test {@link Validator#validateIds(List, String)} with {@code ids},
   * {@code errorMessage}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validateIds(List, String)}
   */
  @Test
  public void testValidateIdsWithIdsErrorMessage_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validateIds(null, "An error occurred"));
  }

  /**
   * Test {@link Validator#validatePageLink(PageLink)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validatePageLink(PageLink)}
   */
  @Test
  public void testValidatePageLink_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validatePageLink(null));
  }

  /**
   * Test {@link Validator#validatePageLink(PageLink)}.
   * <ul>
   *   <li>When {@link PageLink#PageLink(int)} with pageSize is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validatePageLink(PageLink)}
   */
  @Test
  public void testValidatePageLink_whenPageLinkWithPageSizeIsMinusOne() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validatePageLink(new PageLink(-1)));
  }

  /**
   * Test {@link Validator#validatePageLink(PageLink)}.
   * <ul>
   *   <li>When {@link PageLink#PageLink(int, int)} with pageSize is three and page
   * is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Validator#validatePageLink(PageLink)}
   */
  @Test
  public void testValidatePageLink_whenPageLinkWithPageSizeIsThreeAndPageIsMinusOne() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.validatePageLink(new PageLink(3, -1)));
  }

  /**
   * Test {@link Validator#validateEntityDataPageLink(EntityDataPageLink)}.
   * <ul>
   *   <li>Given minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Validator#validateEntityDataPageLink(EntityDataPageLink)}
   */
  @Test
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
   * Method under test:
   * {@link Validator#validateEntityDataPageLink(EntityDataPageLink)}
   */
  @Test
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
   * Method under test:
   * {@link Validator#validateEntityDataPageLink(EntityDataPageLink)}
   */
  @Test
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
  public void testCheckNotNull_whenNull_thenThrowIncorrectParameterException() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> Validator.checkNotNull(null, "An error occurred"));
  }
}
