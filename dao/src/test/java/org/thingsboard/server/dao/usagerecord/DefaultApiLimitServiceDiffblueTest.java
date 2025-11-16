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
package org.thingsboard.server.dao.usagerecord;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.dao.entity.EntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;

@ContextConfiguration(classes = {DefaultApiLimitService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultApiLimitServiceDiffblueTest {
  @Autowired private DefaultApiLimitService defaultApiLimitService;

  @MockBean private EntityService entityService;

  @MockBean private TbTenantProfileCache tbTenantProfileCache;

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenIllegalArgumentException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.TENANT));
    verify(tenantId).isSysTenantId();
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache} {@link TbTenantProfileCache#get(TenantId)} return
   *       createTenantProfile {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenTbTenantProfileCacheGetReturnCreateTenantProfileName() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act
    boolean actualCheckEntitiesLimitResult =
        defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.TENANT);

    // Assert
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualCheckEntitiesLimitResult);
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache} {@link TbTenantProfileCache#get(TenantId)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenTbTenantProfileCacheGetReturnNull() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(null);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.TENANT));
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache} {@link TbTenantProfileCache#get(TenantId)} return
   *       {@link TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenTbTenantProfileCacheGetReturnTenantProfile() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act
    boolean actualCheckEntitiesLimitResult =
        defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.TENANT);

    // Assert
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualCheckEntitiesLimitResult);
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenTbTenantProfileCache_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(defaultApiLimitService.checkEntitiesLimit(null, EntityType.TENANT));
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}.
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenTbTenantProfileCache_whenSystem_tenant() {
    // Arrange, Act and Assert
    assertTrue(
        defaultApiLimitService.checkEntitiesLimit(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache} {@link TbTenantProfileCache#get(TenantId)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_givenTbTenantProfileCacheGetReturnNull() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(null);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.getLimit(tenantId, mock(Function.class)));
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache} {@link TbTenantProfileCache#get(TenantId)} return
   *       {@link TenantProfile#TenantProfile()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_givenTbTenantProfileCacheGetReturnTenantProfile_thenReturnOne() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    Function<DefaultTenantProfileConfiguration, Number> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<DefaultTenantProfileConfiguration>any()))
        .thenReturn(Integer.valueOf(1));

    // Act
    long actualLimit = defaultApiLimitService.getLimit(tenantId, extractor);

    // Assert
    verify(extractor).apply(isA(DefaultTenantProfileConfiguration.class));
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertEquals(1L, actualLimit);
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}.
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_givenTbTenantProfileCache_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, defaultApiLimitService.getLimit(null, mock(Function.class)));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}.
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_givenTbTenantProfileCache_whenSystem_tenant_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0L, defaultApiLimitService.getLimit(ModelConstants.SYSTEM_TENANT, mock(Function.class)));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantProfile#getDefaultProfileConfiguration()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_thenCallsGetDefaultProfileConfiguration() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getDefaultProfileConfiguration()).thenThrow(new IllegalArgumentException());
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.getLimit(tenantId, mock(Function.class)));
    verify(tenantProfile).getDefaultProfileConfiguration();
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_thenReturnOne() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    Function<DefaultTenantProfileConfiguration, Number> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<DefaultTenantProfileConfiguration>any()))
        .thenReturn(Integer.valueOf(1));

    // Act
    long actualLimit = defaultApiLimitService.getLimit(tenantId, extractor);

    // Assert
    verify(extractor).apply(isA(DefaultTenantProfileConfiguration.class));
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertEquals(1L, actualLimit);
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>When {@link Function} {@link Function#apply(Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_whenFunctionApplyThrowIllegalArgumentException() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    Function<DefaultTenantProfileConfiguration, Number> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<DefaultTenantProfileConfiguration>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultApiLimitService.getLimit(tenantId, extractor));
    verify(extractor).apply(isA(DefaultTenantProfileConfiguration.class));
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>When {@link TenantId} {@link TenantId#isSysTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_whenTenantIdIsSysTenantIdThrowIllegalArgumentException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.getLimit(tenantId, mock(Function.class)));
    verify(tenantId).isSysTenantId();
  }
}
