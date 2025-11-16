/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.widget.WidgetsBundleDao;

@RunWith(MockitoJUnitRunner.class)
public class WidgetsBundleDataValidatorDiffblueTest {
  @Mock private TenantService tenantService;

  @Mock private WidgetsBundleDao widgetsBundleDao;

  @InjectMocks private WidgetsBundleDataValidator widgetsBundleDataValidator;

  /**
   * Test {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)} with {@code
   * TenantId}, {@code WidgetsBundle}.
   *
   * <p>Method under test: {@link WidgetsBundleDataValidator#validateDataImpl(TenantId,
   * WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleDataValidator.validateDataImpl(TenantId, WidgetsBundle)"})
  public void testValidateDataImplWithTenantIdWidgetsBundle() {
    // Arrange
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    WidgetsBundleDataValidator widgetsBundleDataValidator =
        new WidgetsBundleDataValidator(widgetsBundleDao, new TenantServiceImpl());

    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setTitle("Dr");

    // Act
    widgetsBundleDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetsBundle);

    // Assert
    assertSame(TenantId.SYS_TENANT_ID, widgetsBundle.getTenantId());
  }

  /**
   * Test {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)} with {@code
   * TenantId}, {@code WidgetsBundle}.
   *
   * <p>Method under test: {@link WidgetsBundleDataValidator#validateDataImpl(TenantId,
   * WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleDataValidator.validateDataImpl(TenantId, WidgetsBundle)"})
  public void testValidateDataImplWithTenantIdWidgetsBundle2() {
    // Arrange
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    WidgetsBundleDataValidator widgetsBundleDataValidator =
        new WidgetsBundleDataValidator(widgetsBundleDao, new TenantServiceImpl());

    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(widgetsBundle.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetsBundleDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(widgetsBundle).getTenantId();
    verify(widgetsBundle).getTitle();
  }

  /**
   * Test {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)} with {@code
   * TenantId}, {@code WidgetsBundle}.
   *
   * <p>Method under test: {@link WidgetsBundleDataValidator#validateDataImpl(TenantId,
   * WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleDataValidator.validateDataImpl(TenantId, WidgetsBundle)"})
  public void testValidateDataImplWithTenantIdWidgetsBundle3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.getTenantId()).thenReturn(tenantId);
    when(widgetsBundle.getTitle()).thenReturn("Dr");

    // Act
    widgetsBundleDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetsBundle);

    // Assert
    verify(tenantId).getId();
    verify(widgetsBundle, atLeast(1)).getTenantId();
    verify(widgetsBundle).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)} with {@code
   * TenantId}, {@code WidgetsBundle}.
   *
   * <p>Method under test: {@link WidgetsBundleDataValidator#validateDataImpl(TenantId,
   * WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleDataValidator.validateDataImpl(TenantId, WidgetsBundle)"})
  public void testValidateDataImplWithTenantIdWidgetsBundle4() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.getTenantId()).thenReturn(tenantId);
    when(widgetsBundle.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetsBundleDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(tenantId).getId();
    verify(widgetsBundle, atLeast(1)).getTenantId();
    verify(widgetsBundle).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)} with {@code
   * TenantId}, {@code WidgetsBundle}.
   *
   * <p>Method under test: {@link WidgetsBundleDataValidator#validateDataImpl(TenantId,
   * WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleDataValidator.validateDataImpl(TenantId, WidgetsBundle)"})
  public void testValidateDataImplWithTenantIdWidgetsBundle5() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.getTenantId()).thenReturn(tenantId);
    when(widgetsBundle.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetsBundleDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(tenantId).getId();
    verify(widgetsBundle, atLeast(1)).getTenantId();
    verify(widgetsBundle).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)} with {@code
   * TenantId}, {@code WidgetsBundle}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleDataValidator#validateDataImpl(TenantId,
   * WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleDataValidator.validateDataImpl(TenantId, WidgetsBundle)"})
  public void testValidateDataImplWithTenantIdWidgetsBundle_givenSystem_tenant() {
    // Arrange
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    WidgetsBundleDataValidator widgetsBundleDataValidator =
        new WidgetsBundleDataValidator(widgetsBundleDao, new TenantServiceImpl());

    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetsBundle.getTitle()).thenReturn("Dr");

    // Act
    widgetsBundleDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, widgetsBundle);

    // Assert
    verify(widgetsBundle, atLeast(1)).getTenantId();
    verify(widgetsBundle).getTitle();
  }

  /**
   * Test {@link WidgetsBundleDataValidator#validateDataImpl(TenantId, WidgetsBundle)} with {@code
   * TenantId}, {@code WidgetsBundle}.
   *
   * <ul>
   *   <li>When {@link WidgetsBundle#WidgetsBundle()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleDataValidator#validateDataImpl(TenantId,
   * WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleDataValidator.validateDataImpl(TenantId, WidgetsBundle)"})
  public void testValidateDataImplWithTenantIdWidgetsBundle_whenWidgetsBundle() {
    // Arrange
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    WidgetsBundleDataValidator widgetsBundleDataValidator =
        new WidgetsBundleDataValidator(widgetsBundleDao, new TenantServiceImpl());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetsBundleDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new WidgetsBundle()));
  }

  /**
   * Test {@link WidgetsBundleDataValidator#validateCreate(TenantId, WidgetsBundle)} with {@code
   * TenantId}, {@code WidgetsBundle}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleDataValidator#validateCreate(TenantId,
   * WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleDataValidator.validateCreate(TenantId, WidgetsBundle)"})
  public void testValidateCreateWithTenantIdWidgetsBundle_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    when(widgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle.setTitle(" ");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetsBundleDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(widgetsBundleDao).findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("_"));
  }

  /**
   * Test {@link WidgetsBundleDataValidator#validateUpdate(TenantId, WidgetsBundle)} with {@code
   * TenantId}, {@code WidgetsBundle}.
   *
   * <p>Method under test: {@link WidgetsBundleDataValidator#validateUpdate(TenantId,
   * WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle WidgetsBundleDataValidator.validateUpdate(TenantId, WidgetsBundle)"
  })
  public void testValidateUpdateWithTenantIdWidgetsBundle() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setTenantId(new TenantId(UUID.randomUUID()));

    JpaWidgetsBundleDao widgetsBundleDao = mock(JpaWidgetsBundleDao.class);
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundle);
    WidgetsBundleDataValidator widgetsBundleDataValidator =
        new WidgetsBundleDataValidator(widgetsBundleDao, new TenantServiceImpl());

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle2.setId(new WidgetsBundleId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetsBundleDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, widgetsBundle2));
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetsBundleDataValidator#validateUpdate(TenantId, WidgetsBundle)} with {@code
   * TenantId}, {@code WidgetsBundle}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundle#WidgetsBundle()} Alias is {@code Alias}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleDataValidator#validateUpdate(TenantId,
   * WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle WidgetsBundleDataValidator.validateUpdate(TenantId, WidgetsBundle)"
  })
  public void testValidateUpdateWithTenantIdWidgetsBundle_givenWidgetsBundleAliasIsAlias() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setAlias("Alias");
    widgetsBundle.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    JpaWidgetsBundleDao widgetsBundleDao = mock(JpaWidgetsBundleDao.class);
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundle);
    WidgetsBundleDataValidator widgetsBundleDataValidator =
        new WidgetsBundleDataValidator(widgetsBundleDao, new TenantServiceImpl());

    WidgetsBundle widgetsBundle2 = new WidgetsBundle();
    widgetsBundle2.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle2.setId(new WidgetsBundleId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetsBundleDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, widgetsBundle2));
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetsBundleDataValidator#validateUpdate(TenantId, WidgetsBundle)} with {@code
   * TenantId}, {@code WidgetsBundle}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleDataValidator#validateUpdate(TenantId,
   * WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle WidgetsBundleDataValidator.validateUpdate(TenantId, WidgetsBundle)"
  })
  public void testValidateUpdateWithTenantIdWidgetsBundle_thenCallsFindById() {
    // Arrange
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setId(new WidgetsBundleId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            widgetsBundleDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, widgetsBundle));
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
  }
}
