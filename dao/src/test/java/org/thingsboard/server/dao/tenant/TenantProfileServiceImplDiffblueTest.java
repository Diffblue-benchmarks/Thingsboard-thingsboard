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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;

@ContextConfiguration(classes = {TenantProfileServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class TenantProfileServiceImplDiffblueTest {
  @MockBean private CleanUpService cleanUpService;

  @MockBean private DataValidator<TenantProfile> dataValidator;

  @MockBean private TbTransactionalCache<TenantProfileCacheKey, TenantProfile> tbTransactionalCache;

  @MockBean private TenantProfileDao tenantProfileDao;

  @Autowired private TenantProfileServiceImpl tenantProfileServiceImpl;

  /**
   * Test {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)} with {@code
   * TenantProfileEvictEvent}.
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileServiceImpl.handleEvictEvent(TenantProfileEvictEvent)"})
  public void testHandleEvictEventWithTenantProfileEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    // Act
    tenantProfileServiceImpl.handleEvictEvent(new TenantProfileEvictEvent(null, false));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)} with {@code
   * TenantProfileEvictEvent}.
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileServiceImpl.handleEvictEvent(TenantProfileEvictEvent)"})
  public void testHandleEvictEventWithTenantProfileEvictEvent2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    doThrow(constraintViolationException)
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.handleEvictEvent(new TenantProfileEvictEvent(null, false)));
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)} with {@code
   * TenantProfileEvictEvent}.
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileServiceImpl.handleEvictEvent(TenantProfileEvictEvent)"})
  public void testHandleEvictEventWithTenantProfileEvictEvent3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    // Act
    tenantProfileServiceImpl.handleEvictEvent(
        new TenantProfileEvictEvent(new TenantProfileId(ModelConstants.NULL_UUID), false));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)} with {@code
   * TenantProfileEvictEvent}.
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileServiceImpl.handleEvictEvent(TenantProfileEvictEvent)"})
  public void testHandleEvictEventWithTenantProfileEvictEvent4() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    // Act
    tenantProfileServiceImpl.handleEvictEvent(new TenantProfileEvictEvent(null, true));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileById(TenantId, TenantProfileId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileById(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findTenantProfileById(TenantId, TenantProfileId)"
  })
  public void testFindTenantProfileById() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findTenantProfileById [{}]");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findTenantProfileById(
                ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileById(TenantId, TenantProfileId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileById(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findTenantProfileById(TenantId, TenantProfileId)"
  })
  public void testFindTenantProfileById2() {
    // Arrange
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findTenantProfileById [{}]");
    when(tenantProfileId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findTenantProfileById(
                ModelConstants.SYSTEM_TENANT, tenantProfileId));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileById(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantProfileId} {@link TenantProfileId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileById(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findTenantProfileById(TenantId, TenantProfileId)"
  })
  public void testFindTenantProfileById_givenNull_uuid_whenTenantProfileIdGetIdReturnNull_uuid() {
    // Arrange
    TenantProfile createTenantProfileResult = TenantProfileServiceTest.createTenantProfile("Name");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(createTenantProfileResult);

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    TenantProfile actualFindTenantProfileByIdResult =
        tenantProfileServiceImpl.findTenantProfileById(
            ModelConstants.SYSTEM_TENANT, tenantProfileId);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfileId).getId();
    assertSame(createTenantProfileResult, actualFindTenantProfileByIdResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileById(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Then return createTenantProfile {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileById(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findTenantProfileById(TenantId, TenantProfileId)"
  })
  public void testFindTenantProfileById_thenReturnCreateTenantProfileName() {
    // Arrange
    TenantProfile createTenantProfileResult = TenantProfileServiceTest.createTenantProfile("Name");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(createTenantProfileResult);

    // Act
    TenantProfile actualFindTenantProfileByIdResult =
        tenantProfileServiceImpl.findTenantProfileById(
            ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    assertSame(createTenantProfileResult, actualFindTenantProfileByIdResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityInfo TenantProfileServiceImpl.findTenantProfileInfoById(TenantId, TenantProfileId)"
  })
  public void testFindTenantProfileInfoById() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act
    EntityInfo actualFindTenantProfileInfoByIdResult =
        tenantProfileServiceImpl.findTenantProfileInfoById(
            ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    assertEquals("Name", actualFindTenantProfileInfoByIdResult.getName());
    assertNull(actualFindTenantProfileInfoByIdResult.getId());
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityInfo TenantProfileServiceImpl.findTenantProfileInfoById(TenantId, TenantProfileId)"
  })
  public void testFindTenantProfileInfoById2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findTenantProfileInfoById [{}]");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findTenantProfileInfoById(
                ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityInfo TenantProfileServiceImpl.findTenantProfileInfoById(TenantId, TenantProfileId)"
  })
  public void testFindTenantProfileInfoById3() {
    // Arrange
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findTenantProfileInfoById [{}]");
    when(tenantProfileId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findTenantProfileInfoById(
                ModelConstants.SYSTEM_TENANT, tenantProfileId));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityInfo TenantProfileServiceImpl.findTenantProfileInfoById(TenantId, TenantProfileId)"
  })
  public void testFindTenantProfileInfoById_givenNull_uuid() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    EntityInfo actualFindTenantProfileInfoByIdResult =
        tenantProfileServiceImpl.findTenantProfileInfoById(
            ModelConstants.SYSTEM_TENANT, tenantProfileId);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfileId).getId();
    assertEquals("Name", actualFindTenantProfileInfoByIdResult.getName());
    assertNull(actualFindTenantProfileInfoByIdResult.getId());
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile} {@link TenantProfile#getName()} return {@code Name}.
   *   <li>Then calls {@link TenantProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityInfo TenantProfileServiceImpl.findTenantProfileInfoById(TenantId, TenantProfileId)"
  })
  public void testFindTenantProfileInfoById_givenTenantProfileGetNameReturnName_thenCallsGetId() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getName()).thenReturn("Name");
    when(tenantProfile.getId()).thenReturn(null);
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(tenantProfile);

    // Act
    EntityInfo actualFindTenantProfileInfoByIdResult =
        tenantProfileServiceImpl.findTenantProfileInfoById(
            ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfile).getId();
    verify(tenantProfile).getName();
    assertEquals("Name", actualFindTenantProfileInfoByIdResult.getName());
    assertNull(actualFindTenantProfileInfoByIdResult.getId());
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityInfo TenantProfileServiceImpl.findTenantProfileInfoById(TenantId, TenantProfileId)"
  })
  public void testFindTenantProfileInfoById_thenReturnNull() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(null);

    // Act
    EntityInfo actualFindTenantProfileInfoByIdResult =
        tenantProfileServiceImpl.findTenantProfileInfoById(
            ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    assertNull(actualFindTenantProfileInfoByIdResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#saveTenantProfile(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.saveTenantProfile(TenantId, TenantProfile)"
  })
  public void testSaveTenantProfile() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    TenantProfile tenantProfile = mock(TenantProfile.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveTenantProfile [{}]");
    when(tenantProfile.getId()).thenThrow(constraintViolationException);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(tenantProfile);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.saveTenantProfile(
                ModelConstants.SYSTEM_TENANT,
                TenantProfileServiceTest.createTenantProfile("Name")));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile).getId();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#saveTenantProfile(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.saveTenantProfile(TenantId, TenantProfile)"
  })
  public void testSaveTenantProfile2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    TenantProfile tenantProfile = mock(TenantProfile.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), null);
    when(tenantProfile.getId()).thenThrow(constraintViolationException);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(tenantProfile);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.saveTenantProfile(
                ModelConstants.SYSTEM_TENANT,
                TenantProfileServiceTest.createTenantProfile("Name")));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile).getId();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#saveTenantProfile(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.saveTenantProfile(TenantId, TenantProfile)"
  })
  public void testSaveTenantProfile_givenTbTransactionalCache() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveTenantProfile [{}]");
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.saveTenantProfile(
                ModelConstants.SYSTEM_TENANT,
                TenantProfileServiceTest.createTenantProfile("Name")));
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When createTenantProfile {@code Name} Default is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#saveTenantProfile(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.saveTenantProfile(TenantId, TenantProfile)"
  })
  public void testSaveTenantProfile_givenTrue_whenCreateTenantProfileNameDefaultIsTrue() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    TenantProfile tenantProfile = mock(TenantProfile.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveTenantProfile [{}]");
    when(tenantProfile.getId()).thenThrow(constraintViolationException);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(tenantProfile);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantProfile tenantProfile2 = TenantProfileServiceTest.createTenantProfile("Name");
    tenantProfile2.setDefault(true);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.saveTenantProfile(
                ModelConstants.SYSTEM_TENANT, tenantProfile2));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile).getId();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   *
   * <ul>
   *   <li>Then return createTenantProfile {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#saveTenantProfile(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.saveTenantProfile(TenantId, TenantProfile)"
  })
  public void testSaveTenantProfile_thenReturnCreateTenantProfileName() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    TenantProfile createTenantProfileResult = TenantProfileServiceTest.createTenantProfile("Name");
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(createTenantProfileResult);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act
    TenantProfile actualSaveTenantProfileResult =
        tenantProfileServiceImpl.saveTenantProfile(
            ModelConstants.SYSTEM_TENANT, TenantProfileServiceTest.createTenantProfile("Name"));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
    assertSame(createTenantProfileResult, actualSaveTenantProfileResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#saveTenantProfile(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.saveTenantProfile(TenantId, TenantProfile)"
  })
  public void testSaveTenantProfile_thenThrowDataValidationException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    TenantProfile tenantProfile = mock(TenantProfile.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "tenant_profile_name_unq_key");
    when(tenantProfile.getId()).thenThrow(constraintViolationException);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(tenantProfile);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tenantProfileServiceImpl.saveTenantProfile(
                ModelConstants.SYSTEM_TENANT,
                TenantProfileServiceTest.createTenantProfile("Name")));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile).getId();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   *
   * <ul>
   *   <li>When {@link TenantProfile} {@link TenantProfile#isDefault()} return {@code true}.
   *   <li>Then calls {@link TenantProfile#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#saveTenantProfile(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.saveTenantProfile(TenantId, TenantProfile)"
  })
  public void testSaveTenantProfile_whenTenantProfileIsDefaultReturnTrue_thenCallsIsDefault() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    TenantProfile tenantProfile = mock(TenantProfile.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveTenantProfile [{}]");
    when(tenantProfile.getId()).thenThrow(constraintViolationException);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(tenantProfile);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantProfile tenantProfile2 = mock(TenantProfile.class);
    when(tenantProfile2.isDefault()).thenReturn(true);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.saveTenantProfile(
                ModelConstants.SYSTEM_TENANT, tenantProfile2));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile).getId();
    verify(tenantProfile2).isDefault();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantProfileServiceImpl.deleteTenantProfile(TenantId, TenantProfileId)"
  })
  public void testDeleteTenantProfile() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteTenantProfile [{}]");
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.deleteTenantProfile(
                ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantProfileServiceImpl.deleteTenantProfile(TenantId, TenantProfileId)"
  })
  public void testDeleteTenantProfile2() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteTenantProfile [{}]");
    when(tenantProfile.isDefault()).thenThrow(constraintViolationException);
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(tenantProfile);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.deleteTenantProfile(
                ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tenantProfile).isDefault();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantProfileServiceImpl.deleteTenantProfile(TenantId, TenantProfileId)"
  })
  public void testDeleteTenantProfile3() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(false);
    when(tenantProfile.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteTenantProfile [{}]");
    doThrow(constraintViolationException)
        .when(tenantProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(tenantProfile);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.deleteTenantProfile(
                ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tenantProfile).getId();
    verify(tenantProfile).isDefault();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache} {@link TbTransactionalCache#evict(Collection)} does
   *       nothing.
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantProfileServiceImpl.deleteTenantProfile(TenantId, TenantProfileId)"
  })
  public void testDeleteTenantProfile_givenTbTransactionalCacheEvictDoesNothing_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(false);
    when(tenantProfile.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));
    doNothing().when(tenantProfileDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(tenantProfile);

    // Act
    tenantProfileServiceImpl.deleteTenantProfile(
        ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile).getId();
    verify(tenantProfile).isDefault();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Given {@link TenantProfileId} {@link TenantProfileId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantProfileServiceImpl.deleteTenantProfile(TenantId, TenantProfileId)"
  })
  public void testDeleteTenantProfile_givenTenantProfileIdGetIdReturnNull_uuid_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(false);
    when(tenantProfile.getId()).thenReturn(tenantProfileId);
    doNothing().when(tenantProfileDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(tenantProfile);

    // Act
    tenantProfileServiceImpl.deleteTenantProfile(
        ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile).getId();
    verify(tenantProfile).isDefault();
    verify(tenantProfileId).getId();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Given {@link TenantProfileServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantProfileServiceImpl.deleteTenantProfile(TenantId, TenantProfileId)"
  })
  public void testDeleteTenantProfile_givenTenantProfileServiceImpl() {
    // Arrange
    TenantProfileServiceImpl tenantProfileServiceImpl = new TenantProfileServiceImpl();

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteTenantProfile [{}]");
    when(tenantProfileId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.deleteTenantProfile(
                ModelConstants.SYSTEM_TENANT, tenantProfileId));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantProfileServiceImpl.deleteTenantProfile(TenantId, TenantProfileId)"
  })
  public void testDeleteTenantProfile_thenThrowDataValidationException() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(tenantProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tenantProfileServiceImpl.deleteTenantProfile(
                ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tenantProfile).isDefault();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantProfileServiceImpl.findTenantProfiles(TenantId, PageLink)"})
  public void testFindTenantProfiles() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findTenantProfiles pageLink [{}]");
    when(tenantProfileDao.findTenantProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findTenantProfiles(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantProfileDao).findTenantProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantProfileServiceImpl.findTenantProfiles(TenantId, PageLink)"})
  public void testFindTenantProfiles2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findTenantProfiles pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantProfileServiceImpl.findTenantProfiles(TenantId, PageLink)"})
  public void testFindTenantProfiles3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantProfileServiceImpl.findTenantProfiles(TenantId, PageLink)"})
  public void testFindTenantProfiles4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findTenantProfiles pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantProfileServiceImpl.findTenantProfiles(TenantId, PageLink)"})
  public void testFindTenantProfiles_givenBy_created_time_desc() {
    // Arrange
    PageData<TenantProfile> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<TenantProfile> actualFindTenantProfilesResult =
        tenantProfileServiceImpl.findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantProfileDao).findTenantProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantProfilesResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantProfileServiceImpl.findTenantProfiles(TenantId, PageLink)"})
  public void testFindTenantProfiles_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<TenantProfile> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<TenantProfile> actualFindTenantProfilesResult =
        tenantProfileServiceImpl.findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(tenantProfileDao).findTenantProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantProfilesResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantProfileServiceImpl.findTenantProfiles(TenantId, PageLink)"})
  public void testFindTenantProfiles_givenSortOrderGetPropertyReturnNull_thenCallsGetProperty() {
    // Arrange
    PageData<TenantProfile> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<TenantProfile> actualFindTenantProfilesResult =
        tenantProfileServiceImpl.findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(tenantProfileDao).findTenantProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantProfilesResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantProfileServiceImpl.findTenantProfiles(TenantId, PageLink)"})
  public void testFindTenantProfiles_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TenantProfile> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<TenantProfile> actualFindTenantProfilesResult =
        tenantProfileServiceImpl.findTenantProfiles(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantProfileDao).findTenantProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantProfilesResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData TenantProfileServiceImpl.findTenantProfileInfos(TenantId, PageLink)"
  })
  public void testFindTenantProfileInfos() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findTenantProfileInfos pageLink [{}]");
    when(tenantProfileDao.findTenantProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findTenantProfileInfos(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantProfileDao).findTenantProfileInfos(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData TenantProfileServiceImpl.findTenantProfileInfos(TenantId, PageLink)"
  })
  public void testFindTenantProfileInfos2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findTenantProfileInfos pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findTenantProfileInfos(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData TenantProfileServiceImpl.findTenantProfileInfos(TenantId, PageLink)"
  })
  public void testFindTenantProfileInfos3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findTenantProfileInfos(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData TenantProfileServiceImpl.findTenantProfileInfos(TenantId, PageLink)"
  })
  public void testFindTenantProfileInfos4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findTenantProfileInfos pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findTenantProfileInfos(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData TenantProfileServiceImpl.findTenantProfileInfos(TenantId, PageLink)"
  })
  public void testFindTenantProfileInfos_givenBy_created_time_desc() {
    // Arrange
    PageData<EntityInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityInfo> actualFindTenantProfileInfosResult =
        tenantProfileServiceImpl.findTenantProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantProfileDao).findTenantProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantProfileInfosResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData TenantProfileServiceImpl.findTenantProfileInfos(TenantId, PageLink)"
  })
  public void testFindTenantProfileInfos_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<EntityInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityInfo> actualFindTenantProfileInfosResult =
        tenantProfileServiceImpl.findTenantProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(tenantProfileDao).findTenantProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantProfileInfosResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData TenantProfileServiceImpl.findTenantProfileInfos(TenantId, PageLink)"
  })
  public void testFindTenantProfileInfos_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<EntityInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EntityInfo> actualFindTenantProfileInfosResult =
        tenantProfileServiceImpl.findTenantProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(tenantProfileDao).findTenantProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantProfileInfosResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData TenantProfileServiceImpl.findTenantProfileInfos(TenantId, PageLink)"
  })
  public void testFindTenantProfileInfos_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityInfo> actualFindTenantProfileInfosResult =
        tenantProfileServiceImpl.findTenantProfileInfos(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantProfileDao).findTenantProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantProfileInfosResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findOrCreateDefaultTenantProfile(TenantId)"
  })
  public void testFindOrCreateDefaultTenantProfile() {
    // Arrange
    TenantProfile createTenantProfileResult = TenantProfileServiceTest.createTenantProfile("Name");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(createTenantProfileResult);

    // Act
    TenantProfile actualFindOrCreateDefaultTenantProfileResult =
        tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    assertSame(createTenantProfileResult, actualFindOrCreateDefaultTenantProfileResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findOrCreateDefaultTenantProfile(TenantId)"
  })
  public void testFindOrCreateDefaultTenantProfile2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findOrCreateDefaultTenantProfile");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(
                ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findOrCreateDefaultTenantProfile(TenantId)"
  })
  public void testFindOrCreateDefaultTenantProfile3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(null);
    TenantProfile createTenantProfileResult = TenantProfileServiceTest.createTenantProfile("Name");
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(createTenantProfileResult);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act
    TenantProfile actualFindOrCreateDefaultTenantProfileResult =
        tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
    assertSame(createTenantProfileResult, actualFindOrCreateDefaultTenantProfileResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findOrCreateDefaultTenantProfile(TenantId)"
  })
  public void testFindOrCreateDefaultTenantProfile4() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(null);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findOrCreateDefaultTenantProfile");
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(
                ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findOrCreateDefaultTenantProfile(TenantId)"
  })
  public void testFindOrCreateDefaultTenantProfile5() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(null);

    TenantProfile tenantProfile = mock(TenantProfile.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findOrCreateDefaultTenantProfile");
    when(tenantProfile.getId()).thenThrow(constraintViolationException);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(tenantProfile);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(
                ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfile).getId();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findOrCreateDefaultTenantProfile(TenantId)"
  })
  public void testFindOrCreateDefaultTenantProfile6() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(null);

    TenantProfile tenantProfile = mock(TenantProfile.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), null);
    when(tenantProfile.getId()).thenThrow(constraintViolationException);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(tenantProfile);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(
                ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfile).getId();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findOrCreateDefaultTenantProfile(TenantId)"
  })
  public void testFindOrCreateDefaultTenantProfile7() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(null);

    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(tenantProfile);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act
    tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfile, atLeast(1)).getId();
    verify(tenantProfile).isDefault();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link TenantProfile} {@link TenantProfile#getId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findOrCreateDefaultTenantProfile(TenantId)"
  })
  public void testFindOrCreateDefaultTenantProfile_givenTenantProfileGetIdReturnNull() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(null);

    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getId()).thenReturn(null);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(tenantProfile);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act
    tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfile, atLeast(1)).getId();
    verify(tenantProfile).isDefault();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileServiceImpl.findOrCreateDefaultTenantProfile(TenantId)"
  })
  public void testFindOrCreateDefaultTenantProfile_thenThrowDataValidationException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(null);

    TenantProfile tenantProfile = mock(TenantProfile.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "tenant_profile_name_unq_key");
    when(tenantProfile.getId()).thenThrow(constraintViolationException);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(tenantProfile);
    when(dataValidator.validate(
            Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(
                ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfile).getId();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then return createTenantProfile {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileServiceImpl.findDefaultTenantProfile(TenantId)"})
  public void testFindDefaultTenantProfile_thenReturnCreateTenantProfileName() {
    // Arrange
    TenantProfile createTenantProfileResult = TenantProfileServiceTest.createTenantProfile("Name");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(createTenantProfileResult);

    // Act
    TenantProfile actualFindDefaultTenantProfileResult =
        tenantProfileServiceImpl.findDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    assertSame(createTenantProfileResult, actualFindDefaultTenantProfileResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile TenantProfileServiceImpl.findDefaultTenantProfile(TenantId)"})
  public void testFindDefaultTenantProfile_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findDefaultTenantProfile");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.findDefaultTenantProfile(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityInfo TenantProfileServiceImpl.findDefaultTenantProfileInfo(TenantId)"})
  public void testFindDefaultTenantProfileInfo() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act
    EntityInfo actualFindDefaultTenantProfileInfoResult =
        tenantProfileServiceImpl.findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    assertEquals("Name", actualFindDefaultTenantProfileInfoResult.getName());
    assertNull(actualFindDefaultTenantProfileInfoResult.getId());
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityInfo TenantProfileServiceImpl.findDefaultTenantProfileInfo(TenantId)"})
  public void testFindDefaultTenantProfileInfo2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findDefaultTenantProfileInfo");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityInfo TenantProfileServiceImpl.findDefaultTenantProfileInfo(TenantId)"})
  public void testFindDefaultTenantProfileInfo3() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findDefaultTenantProfileInfo");
    when(tenantProfile.getId()).thenThrow(constraintViolationException);
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(tenantProfile);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfile).getId();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantProfile#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityInfo TenantProfileServiceImpl.findDefaultTenantProfileInfo(TenantId)"})
  public void testFindDefaultTenantProfileInfo_thenCallsGetName() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getName()).thenReturn("Name");
    when(tenantProfile.getId()).thenReturn(null);
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(tenantProfile);

    // Act
    EntityInfo actualFindDefaultTenantProfileInfoResult =
        tenantProfileServiceImpl.findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfile).getId();
    verify(tenantProfile).getName();
    assertEquals("Name", actualFindDefaultTenantProfileInfoResult.getName());
    assertNull(actualFindDefaultTenantProfileInfoResult.getId());
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityInfo TenantProfileServiceImpl.findDefaultTenantProfileInfo(TenantId)"})
  public void testFindDefaultTenantProfileInfo_thenReturnNull() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(null);

    // Act
    EntityInfo actualFindDefaultTenantProfileInfoResult =
        tenantProfileServiceImpl.findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    assertNull(actualFindDefaultTenantProfileInfoResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileServiceImpl.setDefaultTenantProfile(TenantId, TenantProfileId)"
  })
  public void testSetDefaultTenantProfile() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing setDefaultTenantProfile [{}]");
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.setDefaultTenantProfile(
                ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileServiceImpl.setDefaultTenantProfile(TenantId, TenantProfileId)"
  })
  public void testSetDefaultTenantProfile2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing setDefaultTenantProfile [{}]");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenThrow(constraintViolationException);
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.setDefaultTenantProfile(
                ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileServiceImpl.setDefaultTenantProfile(TenantId, TenantProfileId)"
  })
  public void testSetDefaultTenantProfile3() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(null);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing setDefaultTenantProfile [{}]");
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenThrow(constraintViolationException);
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.setDefaultTenantProfile(
                ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Given {@link TenantProfileServiceImpl} (default constructor).
   *   <li>Then calls {@link TenantProfileId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileServiceImpl.setDefaultTenantProfile(TenantId, TenantProfileId)"
  })
  public void testSetDefaultTenantProfile_givenTenantProfileServiceImpl_thenCallsGetId() {
    // Arrange
    TenantProfileServiceImpl tenantProfileServiceImpl = new TenantProfileServiceImpl();

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing setDefaultTenantProfile [{}]");
    when(tenantProfileId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.setDefaultTenantProfile(
                ModelConstants.SYSTEM_TENANT, tenantProfileId));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileServiceImpl.setDefaultTenantProfile(TenantId, TenantProfileId)"
  })
  public void testSetDefaultTenantProfile_thenCallsGetId() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing setDefaultTenantProfile [{}]");
    when(tenantProfile.getId()).thenThrow(constraintViolationException);
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(tenantProfile);
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(
            TenantProfileServiceTest.createTenantProfile("Executing setDefaultTenantProfile [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.setDefaultTenantProfile(
                ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfile).getId();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileServiceImpl.setDefaultTenantProfile(TenantId, TenantProfileId)"
  })
  public void testSetDefaultTenantProfile_thenReturnFalse() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(tenantProfile);

    // Act
    boolean actualSetDefaultTenantProfileResult =
        tenantProfileServiceImpl.setDefaultTenantProfile(
            ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantProfile).isDefault();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualSetDefaultTenantProfileResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId,
   * TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileServiceImpl.setDefaultTenantProfile(TenantId, TenantProfileId)"
  })
  public void testSetDefaultTenantProfile_thenReturnTrue() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(null);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act
    boolean actualSetDefaultTenantProfileResult =
        tenantProfileServiceImpl.setDefaultTenantProfile(
            ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
    assertTrue(actualSetDefaultTenantProfileResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfilesByIds(TenantId, UUID[])}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfilesByIds(TenantId,
   * UUID[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TenantProfileServiceImpl.findTenantProfilesByIds(TenantId, UUID[])"})
  public void testFindTenantProfilesByIds_thenReturnEmpty() {
    // Arrange
    when(tenantProfileDao.findTenantProfilesByIds(Mockito.<TenantId>any(), Mockito.<UUID[]>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<TenantProfile> actualFindTenantProfilesByIdsResult =
        tenantProfileServiceImpl.findTenantProfilesByIds(
            ModelConstants.SYSTEM_TENANT, new UUID[] {ModelConstants.NULL_UUID});

    // Assert
    verify(tenantProfileDao).findTenantProfilesByIds(isA(TenantId.class), isA(UUID[].class));
    assertTrue(actualFindTenantProfilesByIdsResult.isEmpty());
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfilesByIds(TenantId, UUID[])}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findTenantProfilesByIds(TenantId,
   * UUID[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TenantProfileServiceImpl.findTenantProfilesByIds(TenantId, UUID[])"})
  public void testFindTenantProfilesByIds_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(tenantProfileDao.findTenantProfilesByIds(Mockito.<TenantId>any(), Mockito.<UUID[]>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findTenantProfilesByIds(
                ModelConstants.SYSTEM_TENANT, new UUID[] {ModelConstants.NULL_UUID}));
    verify(tenantProfileDao).findTenantProfilesByIds(isA(TenantId.class), isA(UUID[].class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#deleteTenantProfiles(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantProfileDao#findTenantProfiles(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#deleteTenantProfiles(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileServiceImpl.deleteTenantProfiles(TenantId)"})
  public void testDeleteTenantProfiles_thenCallsFindTenantProfiles() {
    // Arrange
    PageData<TenantProfile> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    tenantProfileServiceImpl.deleteTenantProfiles(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileDao).findTenantProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional TenantProfileServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenNull_uuid_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findTenantProfileById [{}]");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenThrow(constraintViolationException);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT, entityId));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    verify(entityId).getId();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional TenantProfileServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenReturnPresent() {
    // Arrange
    TenantProfile createTenantProfileResult = TenantProfileServiceTest.createTenantProfile("Name");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenReturn(createTenantProfileResult);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        tenantProfileServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(createTenantProfileResult, actualFindEntityResult.get());
  }

  /**
   * Test {@link TenantProfileServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional TenantProfileServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findTenantProfileById [{}]");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantProfileCacheKey>any(),
            Mockito.<Supplier<TenantProfile>>any(),
            anyBoolean()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            tenantProfileServiceImpl.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link TenantProfileServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link TenantProfileServiceImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType TenantProfileServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.TENANT_PROFILE, new TenantProfileServiceImpl().getEntityType());
  }
}
