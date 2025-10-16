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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.resource.TbResourceDao;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.widget.WidgetTypeDao;

@ContextConfiguration(classes = {ResourceDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceDataValidatorDiffblueTest {
  @Autowired private ResourceDataValidator resourceDataValidator;

  @MockBean private TbResourceDao tbResourceDao;

  @MockBean private TbTenantProfileCache tbTenantProfileCache;

  @MockBean private TenantService tenantService;

  @MockBean private WidgetTypeDao widgetTypeDao;

  /**
   * Test {@link ResourceDataValidator#validateCreate(TenantId, TbResource)} with {@code TenantId},
   * {@code TbResource}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateCreate(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateCreate(TenantId, TbResource)"})
  public void testValidateCreateWithTenantIdTbResource_givenEmptyString() {
    // Arrange
    TbResource resource = new TbResource(new TbResource());
    resource.setEncodedData("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, resource));
  }

  /**
   * Test {@link ResourceDataValidator#validateCreate(TenantId, TbResource)} with {@code TenantId},
   * {@code TbResource}.
   *
   * <ul>
   *   <li>When {@link TbResource#TbResource()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateCreate(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateCreate(TenantId, TbResource)"})
  public void testValidateCreateWithTenantIdTbResource_whenTbResource() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new TbResource()));
  }

  /**
   * Test {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)} with {@code TenantId},
   * {@code TbResource}.
   *
   * <p>Method under test: {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource ResourceDataValidator.validateUpdate(TenantId, TbResource)"})
  public void testValidateUpdateWithTenantIdTbResource() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceType()).thenThrow(new DataValidationException("An error occurred"));
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource).getData();
    verify(resource).getResourceType();
  }

  /**
   * Test {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)} with {@code TenantId},
   * {@code TbResource}.
   *
   * <p>Method under test: {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource ResourceDataValidator.validateUpdate(TenantId, TbResource)"})
  public void testValidateUpdateWithTenantIdTbResource2() throws UnsupportedEncodingException {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenThrow(new DataValidationException("An error occurred"));

    TbResource resource = mock(TbResource.class);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateUpdate(tenantId, resource));
    verify(resource).getData();
    verify(resource).getResourceType();
    verify(tenantId).isSysTenantId();
  }

  /**
   * Test {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)} with {@code TenantId},
   * {@code TbResource}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource ResourceDataValidator.validateUpdate(TenantId, TbResource)"})
  public void testValidateUpdateWithTenantIdTbResource_givenFalse()
      throws UnsupportedEncodingException {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    TbResource resource = mock(TbResource.class);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateUpdate(tenantId, resource));
    verify(resource).getData();
    verify(resource).getResourceType();
    verify(tenantId).isSysTenantId();
  }

  /**
   * Test {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)} with {@code TenantId},
   * {@code TbResource}.
   *
   * <ul>
   *   <li>Given {@code JS_MODULE}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource ResourceDataValidator.validateUpdate(TenantId, TbResource)"})
  public void testValidateUpdateWithTenantIdTbResource_givenJsModule()
      throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceType()).thenReturn(ResourceType.JS_MODULE);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TbResource actualValidateUpdateResult =
        resourceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, resource);

    // Assert
    verify(resource).getData();
    verify(resource).getResourceType();
    assertSame(resource, actualValidateUpdateResult);
  }

  /**
   * Test {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)} with {@code TenantId},
   * {@code TbResource}.
   *
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.
   *   <li>Then return {@link TbResource}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource ResourceDataValidator.validateUpdate(TenantId, TbResource)"})
  public void testValidateUpdateWithTenantIdTbResource_givenLwm2mModel_thenReturnTbResource()
      throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TbResource actualValidateUpdateResult =
        resourceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, resource);

    // Assert
    verify(resource).getData();
    verify(resource).getResourceType();
    assertSame(resource, actualValidateUpdateResult);
  }

  /**
   * Test {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)} with {@code TenantId},
   * {@code TbResource}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link TbResource}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource ResourceDataValidator.validateUpdate(TenantId, TbResource)"})
  public void testValidateUpdateWithTenantIdTbResource_whenNull_thenReturnTbResource()
      throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TbResource actualValidateUpdateResult = resourceDataValidator.validateUpdate(null, resource);

    // Assert
    verify(resource).getData();
    verify(resource).getResourceType();
    assertSame(resource, actualValidateUpdateResult);
  }

  /**
   * Test {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)} with {@code TenantId},
   * {@code TbResource}.
   *
   * <ul>
   *   <li>When {@link TbResource#TbResource()}.
   *   <li>Then return {@link TbResource#TbResource()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource ResourceDataValidator.validateUpdate(TenantId, TbResource)"})
  public void testValidateUpdateWithTenantIdTbResource_whenTbResource_thenReturnTbResource() {
    // Arrange
    TbResource resource = new TbResource();

    // Act
    TbResource actualValidateUpdateResult =
        resourceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, resource);

    // Assert
    assertSame(resource, actualValidateUpdateResult);
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource2() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceType()).thenThrow(new DataValidationException("An error occurred"));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource3() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenThrow(new DataValidationException("An error occurred"));
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource).getData();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource4() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceKey()).thenThrow(new DataValidationException("An error occurred"));
    when(resource.getData()).thenReturn(null);
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource5() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource).getData();
    verify(resource).getId();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource6() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceKey()).thenReturn(null);
    when(resource.getData()).thenReturn(null);
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource_givenEmptyString() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceKey()).thenReturn("");
    when(resource.getData()).thenReturn(null);
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <ul>
   *   <li>Given {@code Resource Key}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource_givenResourceKey() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getData()).thenReturn(null);
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act
    resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource);

    // Assert
    verify(resource).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <ul>
   *   <li>Given {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource_givenSlash() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn(null);
    when(resource.getFileName()).thenReturn("/");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <ul>
   *   <li>Given {@link TbResourceId#TbResourceId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource_givenTbResourceIdWithIdIsNull_uuid()
      throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act
    resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource);

    // Assert
    verify(resource, atLeast(1)).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getId();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <ul>
   *   <li>When {@link TbResource#TbResource()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource_whenTbResource() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new TbResource()));
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <ul>
   *   <li>When {@link TbResource} {@link TbResource#getFileName()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource_whenTbResourceGetFileNameReturnNull() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn(null);
    when(resource.getFileName()).thenReturn(null);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource).getData();
    verify(resource).getFileName();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)} with {@code
   * TenantId}, {@code TbResource}.
   *
   * <ul>
   *   <li>When {@link TbResource#TbResource()} Title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDataImpl(TenantId, TbResource)"})
  public void testValidateDataImplWithTenantIdTbResource_whenTbResourceTitleIsDr() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
  }

  /**
   * Test {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}.
   *
   * <ul>
   *   <li>Given {@link TbResourceDao} {@link TbResourceDao#getResourceSize(TenantId, TbResourceId)}
   *       return three.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceDataValidator.validateResourceSize(TenantId, TbResourceId, long)"
  })
  public void testValidateResourceSize_givenTbResourceDaoGetResourceSizeReturnThree() {
    // Arrange
    when(tbResourceDao.getResourceSize(Mockito.<TenantId>any(), Mockito.<TbResourceId>any()))
        .thenReturn(3L);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act
    resourceDataValidator.validateResourceSize(tenantId, new TbResourceId(UUID.randomUUID()), 3L);

    // Assert
    verify(tenantId).isSysTenantId();
    verify(tbResourceDao).getResourceSize(isA(TenantId.class), isA(TbResourceId.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceDataValidator.validateResourceSize(TenantId, TbResourceId, long)"
  })
  public void testValidateResourceSize_thenThrowDataValidationException() {
    // Arrange
    when(tbResourceDao.getResourceSize(Mockito.<TenantId>any(), Mockito.<TbResourceId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            resourceDataValidator.validateResourceSize(
                tenantId, new TbResourceId(UUID.randomUUID()), 3L));
    verify(tenantId).isSysTenantId();
    verify(tbResourceDao).getResourceSize(isA(TenantId.class), isA(TbResourceId.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDelete(TenantId, EntityId)"})
  public void testValidateDelete() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            resourceDataValidator.validateDelete(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(widgetTypeDao)
        .findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link WidgetTypeDetails#WidgetTypeDetails()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDelete(TenantId, EntityId)"})
  public void testValidateDelete_givenArrayListAddWidgetTypeDetails() {
    // Arrange
    ArrayList<WidgetTypeDetails> widgetTypeDetailsList = new ArrayList<>();
    widgetTypeDetailsList.add(new WidgetTypeDetails());
    when(widgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsList);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            resourceDataValidator.validateDelete(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(widgetTypeDao)
        .findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceDataValidator.validateDelete(TenantId, EntityId)"})
  public void testValidateDelete_thenCallsFindWidgetTypesInfosByTenantIdAndResourceId() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    resourceDataValidator.validateDelete(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(widgetTypeDao)
        .findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
  }
}
