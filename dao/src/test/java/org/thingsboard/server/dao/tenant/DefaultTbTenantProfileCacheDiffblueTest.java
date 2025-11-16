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
package org.thingsboard.server.dao.tenant;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class DefaultTbTenantProfileCacheDiffblueTest {
  @InjectMocks private DefaultTbTenantProfileCache defaultTbTenantProfileCache;

  @Mock private TenantProfileService tenantProfileService;

  @Mock private TenantService tenantService;

  /**
   * Test {@link DefaultTbTenantProfileCache#get(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>Given {@link TenantProfileService} {@link
   *       TenantProfileService#findTenantProfileById(TenantId, TenantProfileId)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#get(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile DefaultTbTenantProfileCache.get(TenantId)"})
  public void testGetWithTenantId_givenTenantProfileServiceFindTenantProfileByIdReturnNull() {
    // Arrange
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(null);

    Tenant tenant = new Tenant();
    tenant.setTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(tenant);

    // Act
    TenantProfile actualGetResult = defaultTbTenantProfileCache.get(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileService)
        .findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#get(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#findTenantById(TenantId)} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#get(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile DefaultTbTenantProfileCache.get(TenantId)"})
  public void testGetWithTenantId_givenTenantServiceFindTenantByIdReturnNull_thenReturnNull() {
    // Arrange
    TenantService tenantService = mock(TenantService.class);
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);
    DefaultTbTenantProfileCache defaultTbTenantProfileCache =
        new DefaultTbTenantProfileCache(new TenantProfileServiceImpl(), tenantService);

    // Act
    TenantProfile actualGetResult = defaultTbTenantProfileCache.get(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#get(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>Then return createTenantProfile {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#get(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile DefaultTbTenantProfileCache.get(TenantId)"})
  public void testGetWithTenantId_thenReturnCreateTenantProfileName() {
    // Arrange
    TenantProfile createTenantProfileResult = TenantProfileServiceTest.createTenantProfile("Name");
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(createTenantProfileResult);

    Tenant tenant = new Tenant();
    tenant.setTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(tenant);

    // Act
    TenantProfile actualGetResult = defaultTbTenantProfileCache.get(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileService)
        .findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertSame(createTenantProfileResult, actualGetResult);
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#get(TenantProfileId)} with {@code tenantProfileId}.
   *
   * <ul>
   *   <li>Then return createTenantProfile {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#get(TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile DefaultTbTenantProfileCache.get(TenantProfileId)"})
  public void testGetWithTenantProfileId_thenReturnCreateTenantProfileName() {
    // Arrange
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    TenantProfile createTenantProfileResult = TenantProfileServiceTest.createTenantProfile("Name");
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(createTenantProfileResult);
    DefaultTbTenantProfileCache defaultTbTenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());

    // Act
    TenantProfile actualGetResult =
        defaultTbTenantProfileCache.get(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantProfileService)
        .findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    assertSame(createTenantProfileResult, actualGetResult);
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#get(TenantProfileId)} with {@code tenantProfileId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#get(TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile DefaultTbTenantProfileCache.get(TenantProfileId)"})
  public void testGetWithTenantProfileId_thenReturnNull() {
    // Arrange
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(null);
    DefaultTbTenantProfileCache defaultTbTenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());

    // Act
    TenantProfile actualGetResult =
        defaultTbTenantProfileCache.get(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantProfileService)
        .findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantProfileId)} with {@code profileId}.
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#evict(TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbTenantProfileCache.evict(TenantProfileId)"})
  public void testEvictWithProfileId() {
    // Arrange
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));
    DefaultTbTenantProfileCache defaultTbTenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());

    // Act
    defaultTbTenantProfileCache.evict(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantProfileService)
        .findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantProfileId)} with {@code profileId}.
   *
   * <ul>
   *   <li>Given {@link TenantProfileService} {@link
   *       TenantProfileService#findTenantProfileById(TenantId, TenantProfileId)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#evict(TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbTenantProfileCache.evict(TenantProfileId)"})
  public void testEvictWithProfileId_givenTenantProfileServiceFindTenantProfileByIdReturnNull() {
    // Arrange
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(null);
    DefaultTbTenantProfileCache defaultTbTenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());

    // Act
    defaultTbTenantProfileCache.evict(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantProfileService)
        .findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantId)} with {@code tenantId}.
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#evict(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbTenantProfileCache.evict(TenantId)"})
  public void testEvictWithTenantId() {
    // Arrange
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    Tenant tenant = new Tenant();
    tenant.setTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(tenant);

    // Act
    defaultTbTenantProfileCache.evict(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileService)
        .findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>Given {@link TenantProfileService} {@link
   *       TenantProfileService#findTenantProfileById(TenantId, TenantProfileId)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#evict(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbTenantProfileCache.evict(TenantId)"})
  public void testEvictWithTenantId_givenTenantProfileServiceFindTenantProfileByIdReturnNull() {
    // Arrange
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(null);

    Tenant tenant = new Tenant();
    tenant.setTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(tenant);

    // Act
    defaultTbTenantProfileCache.evict(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileService)
        .findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#findTenantById(TenantId)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#evict(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbTenantProfileCache.evict(TenantId)"})
  public void testEvictWithTenantId_givenTenantServiceFindTenantByIdReturnNull() {
    // Arrange
    TenantService tenantService = mock(TenantService.class);
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);
    DefaultTbTenantProfileCache defaultTbTenantProfileCache =
        new DefaultTbTenantProfileCache(new TenantProfileServiceImpl(), tenantService);

    // Act
    defaultTbTenantProfileCache.evict(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId, Consumer)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantService#findTenantById(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId,
   * Consumer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbTenantProfileCache.addListener(TenantId, EntityId, Consumer)"})
  public void testAddListener_thenCallsFindTenantById() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);

    // Act
    defaultTbTenantProfileCache.addListener(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId, Consumer)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantService#findTenantById(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId,
   * Consumer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbTenantProfileCache.addListener(TenantId, EntityId, Consumer)"})
  public void testAddListener_thenCallsFindTenantById2() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);
    Consumer<TenantProfile> profileListener = defaultTbTenantProfileCache::put;

    // Act
    defaultTbTenantProfileCache.addListener(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, profileListener);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
  }
}
