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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.function.Consumer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;

@ContextConfiguration(classes = {DefaultTbTenantProfileCache.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultTbTenantProfileCacheDiffblueTest {
  @Autowired private DefaultTbTenantProfileCache defaultTbTenantProfileCache;

  @MockBean private TenantProfileService tenantProfileService;

  @MockBean private TenantService tenantService;

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
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);

    // Act
    TenantProfile actualGetResult = defaultTbTenantProfileCache.get(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertNull(actualGetResult);
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
    TenantProfile createTenantProfileResult = TenantProfileServiceTest.createTenantProfile("Name");
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(createTenantProfileResult);

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
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(null);

    // Act
    TenantProfile actualGetResult =
        defaultTbTenantProfileCache.get(new TenantProfileId(UUID.randomUUID()));

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
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

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
    when(tenantProfileService.findTenantProfileById(
            Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(null);

    // Act
    defaultTbTenantProfileCache.evict(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantProfileService)
        .findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>Then calls {@link TenantService#findTenantById(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#evict(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbTenantProfileCache.evict(TenantId)"})
  public void testEvictWithTenantId_thenCallsFindTenantById() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);

    // Act
    defaultTbTenantProfileCache.evict(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId, Consumer)}.
   *
   * <p>Method under test: {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId,
   * Consumer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbTenantProfileCache.addListener(TenantId, EntityId, Consumer)"})
  public void testAddListener() {
    // Arrange
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();

    TenantService tenantService = mock(TenantService.class);
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);

    DefaultTbTenantProfileCache defaultTbTenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, tenantService);
    Consumer<TenantProfile> profileListener = defaultTbTenantProfileCache::notifyTenantListeners;
    defaultTbTenantProfileCache.addListener(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, profileListener);

    // Act
    defaultTbTenantProfileCache.addListener(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, mock(Consumer.class));

    // Assert
    verify(tenantService, atLeast(1)).findTenantById(isA(TenantId.class));
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
    Consumer<TenantProfile> profileListener = defaultTbTenantProfileCache::notifyTenantListeners;

    // Act
    defaultTbTenantProfileCache.addListener(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, profileListener);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId, Consumer)}.
   *
   * <ul>
   *   <li>When {@code null}.
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
  public void testAddListener_whenNull_thenCallsFindTenantById() {
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
   *   <li>When {@link TenantId}.
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
  public void testAddListener_whenTenantId_thenCallsFindTenantById() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);
    TenantId tenantId = mock(TenantId.class);
    Consumer<TenantProfile> profileListener = defaultTbTenantProfileCache::notifyTenantListeners;

    // Act
    defaultTbTenantProfileCache.addListener(
        tenantId, BaseEntityService.NULL_CUSTOMER_ID, profileListener);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
  }
}
