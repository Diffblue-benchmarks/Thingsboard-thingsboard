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
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {TenantProfileServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class TenantProfileServiceImplDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<TenantProfile> dataValidator;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TbTransactionalCache<TenantProfileCacheKey, TenantProfile> tbTransactionalCache;

  @MockBean
  private TenantProfileDao tenantProfileDao;

  @Autowired
  private TenantProfileServiceImpl tenantProfileServiceImpl;

  /**
   * Test
   * {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   * with {@code TenantProfileEvictEvent}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithTenantProfileEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    // Act
    tenantProfileServiceImpl.handleEvictEvent(new TenantProfileEvictEvent(null, true));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   * with {@code TenantProfileEvictEvent}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithTenantProfileEvictEvent2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    // Act
    tenantProfileServiceImpl
        .handleEvictEvent(new TenantProfileEvictEvent(new TenantProfileId(ModelConstants.NULL_UUID), true));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   * with {@code TenantProfileEvictEvent}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithTenantProfileEvictEvent3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    // Act
    tenantProfileServiceImpl.handleEvictEvent(new TenantProfileEvictEvent(null, false));

    // Assert that nothing has changed
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   * with {@code TenantProfileEvictEvent}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#handleEvictEvent(TenantProfileEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithTenantProfileEvictEvent4() {
    // Arrange
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<TenantProfileCacheKey>>any());

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.handleEvictEvent(new TenantProfileEvictEvent(null, true)));
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileById(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileById(TenantId, TenantProfileId)}
   */
  @Test
  public void testFindTenantProfileById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    TenantProfile actualFindTenantProfileByIdResult = tenantProfileServiceImpl
        .findTenantProfileById(ModelConstants.SYSTEM_TENANT, tenantProfileId);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfileId).getId();
    assertSame(tenantProfile, actualFindTenantProfileByIdResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileById(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>When {@link TenantProfileId#TenantProfileId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileById(TenantId, TenantProfileId)}
   */
  @Test
  public void testFindTenantProfileById_whenTenantProfileIdWithIdIsNull_uuid() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);

    // Act
    TenantProfile actualFindTenantProfileByIdResult = tenantProfileServiceImpl
        .findTenantProfileById(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    assertSame(tenantProfile, actualFindTenantProfileByIdResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}
   */
  @Test
  public void testFindTenantProfileInfoById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileServiceImpl.findTenantProfileInfoById(ModelConstants.SYSTEM_TENANT, tenantProfileId));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfile).getId();
    verify(tenantProfileId).getId();
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Given {@link TenantProfile} {@link TenantProfile#getName()} return
   * {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}
   */
  @Test
  public void testFindTenantProfileInfoById_givenTenantProfileGetNameReturnName_thenReturnName() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getName()).thenReturn("Name");
    when(tenantProfile.getId()).thenReturn(null);
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);

    // Act
    EntityInfo actualFindTenantProfileInfoByIdResult = tenantProfileServiceImpl
        .findTenantProfileInfoById(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfile).getId();
    verify(tenantProfile).getName();
    assertEquals("Name", actualFindTenantProfileInfoByIdResult.getName());
    assertNull(actualFindTenantProfileInfoByIdResult.getId());
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}
   */
  @Test
  public void testFindTenantProfileInfoById_thenReturnNameIsNull() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(new TenantProfile());

    // Act
    EntityInfo actualFindTenantProfileInfoByIdResult = tenantProfileServiceImpl
        .findTenantProfileInfoById(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    assertNull(actualFindTenantProfileInfoByIdResult.getName());
    assertNull(actualFindTenantProfileInfoByIdResult.getId());
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}
   */
  @Test
  public void testFindTenantProfileInfoById_thenReturnNull() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(null);

    // Act
    EntityInfo actualFindTenantProfileInfoByIdResult = tenantProfileServiceImpl
        .findTenantProfileInfoById(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    assertNull(actualFindTenantProfileInfoByIdResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileInfoById(TenantId, TenantProfileId)}
   */
  @Test
  public void testFindTenantProfileInfoById_thenThrowDataValidationException() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> tenantProfileServiceImpl
        .findTenantProfileInfoById(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfile).getId();
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}
   */
  @Test
  public void testSaveTenantProfile() {
    // Arrange
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing saveTenantProfile [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.saveTenantProfile(ModelConstants.SYSTEM_TENANT, new TenantProfile()));
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}
   */
  @Test
  public void testSaveTenantProfile2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(tenantProfile);
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(new TenantProfile());

    // Act
    tenantProfileServiceImpl.saveTenantProfile(ModelConstants.SYSTEM_TENANT, new TenantProfile());

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile, atLeast(1)).getId();
    verify(tenantProfile).isDefault();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}
   */
  @Test
  public void testSaveTenantProfile3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getId()).thenReturn(null);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(tenantProfile);
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(new TenantProfile());
    TenantProfile tenantProfile2 = mock(TenantProfile.class);
    when(tenantProfile2.isDefault()).thenReturn(true);
    when(tenantProfile2.getId()).thenThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "Executing saveTenantProfile [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.saveTenantProfile(ModelConstants.SYSTEM_TENANT, tenantProfile2));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(Collection.class));
    verify(tenantProfile2).getId();
    verify(tenantProfile, atLeast(1)).getId();
    verify(tenantProfile).isDefault();
    verify(tenantProfile2).isDefault();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TenantProfile} {@link TenantProfile#getId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}
   */
  @Test
  public void testSaveTenantProfile_givenNull_whenTenantProfileGetIdReturnNull() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getId()).thenReturn(null);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(tenantProfile);
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(new TenantProfile());
    TenantProfile tenantProfile2 = mock(TenantProfile.class);
    when(tenantProfile2.getId()).thenReturn(null);

    // Act
    tenantProfileServiceImpl.saveTenantProfile(ModelConstants.SYSTEM_TENANT, tenantProfile2);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile2).getId();
    verify(tenantProfile, atLeast(1)).getId();
    verify(tenantProfile).isDefault();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   * <ul>
   *   <li>Given {@link TenantProfile} {@link TenantProfile#getId()} return
   * {@code null}.</li>
   *   <li>Then calls {@link TenantProfile#isDefault()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}
   */
  @Test
  public void testSaveTenantProfile_givenTenantProfileGetIdReturnNull_thenCallsIsDefault() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getId()).thenReturn(null);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(tenantProfile);
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(new TenantProfile());

    // Act
    tenantProfileServiceImpl.saveTenantProfile(ModelConstants.SYSTEM_TENANT, new TenantProfile());

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile, atLeast(1)).getId();
    verify(tenantProfile).isDefault();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   * <ul>
   *   <li>Given {@link TenantProfileId#TenantProfileId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}
   */
  @Test
  public void testSaveTenantProfile_givenTenantProfileIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getId()).thenReturn(null);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(tenantProfile);
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(new TenantProfile());
    TenantProfile tenantProfile2 = mock(TenantProfile.class);
    when(tenantProfile2.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));

    // Act
    tenantProfileServiceImpl.saveTenantProfile(ModelConstants.SYSTEM_TENANT, tenantProfile2);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile2).getId();
    verify(tenantProfile, atLeast(1)).getId();
    verify(tenantProfile).isDefault();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   * <ul>
   *   <li>Then return {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}
   */
  @Test
  public void testSaveTenantProfile_thenReturnTenantProfile() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    TenantProfile tenantProfile = new TenantProfile();
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(tenantProfile);
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(new TenantProfile());

    // Act
    TenantProfile actualSaveTenantProfileResult = tenantProfileServiceImpl
        .saveTenantProfile(ModelConstants.SYSTEM_TENANT, new TenantProfile());

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
    assertSame(tenantProfile, actualSaveTenantProfileResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#saveTenantProfile(TenantId, TenantProfile)}
   */
  @Test
  public void testSaveTenantProfile_thenThrowDataValidationException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(tenantProfile);
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(new TenantProfile());

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setDefault(true);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileServiceImpl.saveTenantProfile(ModelConstants.SYSTEM_TENANT, tenantProfile2));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantProfile).getId();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}
   */
  @Test
  public void testDeleteTenantProfile_givenNull_uuid_thenCallsGetId() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(tenantProfile);
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileServiceImpl.deleteTenantProfile(ModelConstants.SYSTEM_TENANT, tenantProfileId));
    verify(tenantProfile).isDefault();
    verify(tenantProfileId, atLeast(1)).getId();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Given {@link TenantProfile} {@link TenantProfile#isDefault()} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}
   */
  @Test
  public void testDeleteTenantProfile_givenTenantProfileIsDefaultReturnTrue() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(tenantProfile);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> tenantProfileServiceImpl
        .deleteTenantProfile(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tenantProfile).isDefault();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#deleteTenantProfile(TenantId, TenantProfileId)}
   */
  @Test
  public void testDeleteTenantProfile_thenThrowDataValidationException() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(tenantProfile);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> tenantProfileServiceImpl
        .deleteTenantProfile(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tenantProfile).isDefault();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfiles_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<TenantProfile> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<TenantProfile> actualFindTenantProfilesResult = tenantProfileServiceImpl
        .findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantProfileDao).findTenantProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantProfilesResult.EMPTY_PAGE_DATA, actualFindTenantProfilesResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with property is empty string and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfiles_givenSortOrderWithPropertyIsEmptyStringAndDirectionIsAsc() {
    // Arrange
    PageData<TenantProfile> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<TenantProfile> actualFindTenantProfilesResult = tenantProfileServiceImpl
        .findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantProfileDao).findTenantProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantProfilesResult.EMPTY_PAGE_DATA, actualFindTenantProfilesResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfiles_thenThrowConstraintViolationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findTenantProfiles pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfiles_thenThrowDataValidationException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileServiceImpl.findTenantProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfiles(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfiles_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TenantProfile> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<TenantProfile> actualFindTenantProfilesResult = tenantProfileServiceImpl
        .findTenantProfiles(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantProfileDao).findTenantProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantProfilesResult.EMPTY_PAGE_DATA, actualFindTenantProfilesResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfileInfos() {
    // Arrange
    PageData<EntityInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<EntityInfo> actualFindTenantProfileInfosResult = tenantProfileServiceImpl
        .findTenantProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantProfileDao).findTenantProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantProfileInfosResult.EMPTY_PAGE_DATA, actualFindTenantProfileInfosResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfileInfos_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<EntityInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<EntityInfo> actualFindTenantProfileInfosResult = tenantProfileServiceImpl
        .findTenantProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantProfileDao).findTenantProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantProfileInfosResult.EMPTY_PAGE_DATA, actualFindTenantProfileInfosResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfileInfos_thenThrowConstraintViolationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findTenantProfileInfos pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.findTenantProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfileInfos_thenThrowDataValidationException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileServiceImpl.findTenantProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfileInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantProfileInfos_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntityInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantProfileDao.findTenantProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityInfo> actualFindTenantProfileInfosResult = tenantProfileServiceImpl
        .findTenantProfileInfos(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantProfileDao).findTenantProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantProfileInfosResult.EMPTY_PAGE_DATA, actualFindTenantProfileInfosResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  public void testFindOrCreateDefaultTenantProfile() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);

    // Act
    TenantProfile actualFindOrCreateDefaultTenantProfileResult = tenantProfileServiceImpl
        .findOrCreateDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    assertSame(tenantProfile, actualFindOrCreateDefaultTenantProfileResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  public void testFindOrCreateDefaultTenantProfile2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(null);
    TenantProfile tenantProfile = new TenantProfile();
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(tenantProfile);
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(new TenantProfile());

    // Act
    TenantProfile actualFindOrCreateDefaultTenantProfileResult = tenantProfileServiceImpl
        .findOrCreateDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
    assertSame(tenantProfile, actualFindOrCreateDefaultTenantProfileResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  public void testFindOrCreateDefaultTenantProfile3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(null);
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(tenantProfile);
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(new TenantProfile());

    // Act
    tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfile, atLeast(1)).getId();
    verify(tenantProfile).isDefault();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   * <ul>
   *   <li>Given {@link TenantProfile} {@link TenantProfile#getId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  public void testFindOrCreateDefaultTenantProfile_givenTenantProfileGetIdReturnNull() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(null);
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getId()).thenReturn(null);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(tenantProfile);
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenReturn(new TenantProfile());

    // Act
    tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfile, atLeast(1)).getId();
    verify(tenantProfile).isDefault();
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findOrCreateDefaultTenantProfile(TenantId)}
   */
  @Test
  public void testFindOrCreateDefaultTenantProfile_thenThrowConstraintViolationException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(null);
    when(dataValidator.validate(Mockito.<TenantProfile>any(), Mockito.<Function<TenantProfile, TenantId>>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing findOrCreateDefaultTenantProfile"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.findOrCreateDefaultTenantProfile(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(dataValidator).validate(isA(TenantProfile.class), isA(Function.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfile(TenantId)}.
   * <ul>
   *   <li>Then return {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findDefaultTenantProfile(TenantId)}
   */
  @Test
  public void testFindDefaultTenantProfile_thenReturnTenantProfile() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);

    // Act
    TenantProfile actualFindDefaultTenantProfileResult = tenantProfileServiceImpl
        .findDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    assertSame(tenantProfile, actualFindDefaultTenantProfileResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfile(TenantId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findDefaultTenantProfile(TenantId)}
   */
  @Test
  public void testFindDefaultTenantProfile_thenThrowConstraintViolationException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing findDefaultTenantProfile"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.findDefaultTenantProfile(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}.
   * <ul>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  public void testFindDefaultTenantProfileInfo_thenReturnName() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getName()).thenReturn("Name");
    when(tenantProfile.getId()).thenReturn(null);
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);

    // Act
    EntityInfo actualFindDefaultTenantProfileInfoResult = tenantProfileServiceImpl
        .findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfile).getId();
    verify(tenantProfile).getName();
    assertEquals("Name", actualFindDefaultTenantProfileInfoResult.getName());
    assertNull(actualFindDefaultTenantProfileInfoResult.getId());
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}.
   * <ul>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  public void testFindDefaultTenantProfileInfo_thenReturnNameIsNull() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(new TenantProfile());

    // Act
    EntityInfo actualFindDefaultTenantProfileInfoResult = tenantProfileServiceImpl
        .findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    assertNull(actualFindDefaultTenantProfileInfoResult.getName());
    assertNull(actualFindDefaultTenantProfileInfoResult.getId());
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  public void testFindDefaultTenantProfileInfo_thenReturnNull() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(null);

    // Act
    EntityInfo actualFindDefaultTenantProfileInfoResult = tenantProfileServiceImpl
        .findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    assertNull(actualFindDefaultTenantProfileInfoResult);
  }

  /**
   * Test {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  public void testFindDefaultTenantProfileInfo_thenThrowDataValidationException() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileServiceImpl.findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfile).getId();
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}
   */
  @Test
  public void testSetDefaultTenantProfile() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new TenantProfile());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> tenantProfileServiceImpl
        .setDefaultTenantProfile(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}
   */
  @Test
  public void testSetDefaultTenantProfile2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(null);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(new TenantProfile());
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new TenantProfile());

    // Act
    boolean actualSetDefaultTenantProfileResult = tenantProfileServiceImpl
        .setDefaultTenantProfile(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantProfileDao).save(isA(TenantId.class), isA(TenantProfile.class));
    assertTrue(actualSetDefaultTenantProfileResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}
   */
  @Test
  public void testSetDefaultTenantProfile_givenNull_uuid_thenCallsGetId() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(tenantProfile);
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileServiceImpl.setDefaultTenantProfile(ModelConstants.SYSTEM_TENANT, tenantProfileId));
    verify(tenantProfile).isDefault();
    verify(tenantProfileId, atLeast(1)).getId();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Given {@link TenantProfile} {@link TenantProfile#getId()} return
   * {@link TenantProfileId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}
   */
  @Test
  public void testSetDefaultTenantProfile_givenTenantProfileGetIdReturnTenantProfileId() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    doNothing().when(tenantProfile).setDefault(anyBoolean());
    when(tenantProfile.getId()).thenReturn(mock(TenantProfileId.class));
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(new TenantProfile());
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new TenantProfile());

    // Act
    boolean actualSetDefaultTenantProfileResult = tenantProfileServiceImpl
        .setDefaultTenantProfile(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfile, atLeast(1)).getId();
    verify(tenantProfile).setDefault(eq(false));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantProfileDao, atLeast(1)).save(isA(TenantId.class), Mockito.<TenantProfile>any());
    assertTrue(actualSetDefaultTenantProfileResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Then calls {@link TenantProfile#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}
   */
  @Test
  public void testSetDefaultTenantProfile_thenCallsGetId() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    doNothing().when(tenantProfile).setDefault(anyBoolean());
    when(tenantProfile.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);
    when(tenantProfileDao.save(Mockito.<TenantId>any(), Mockito.<TenantProfile>any())).thenReturn(new TenantProfile());
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new TenantProfile());

    // Act
    boolean actualSetDefaultTenantProfileResult = tenantProfileServiceImpl
        .setDefaultTenantProfile(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<Collection<TenantProfileCacheKey>>any());
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(tenantProfile, atLeast(1)).getId();
    verify(tenantProfile).setDefault(eq(false));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantProfileDao, atLeast(1)).save(isA(TenantId.class), Mockito.<TenantProfile>any());
    assertTrue(actualSetDefaultTenantProfileResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#setDefaultTenantProfile(TenantId, TenantProfileId)}
   */
  @Test
  public void testSetDefaultTenantProfile_thenReturnFalse() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(tenantProfile);

    // Act
    boolean actualSetDefaultTenantProfileResult = tenantProfileServiceImpl
        .setDefaultTenantProfile(ModelConstants.SYSTEM_TENANT, new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantProfile).isDefault();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualSetDefaultTenantProfileResult);
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfilesByIds(TenantId, UUID[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfilesByIds(TenantId, UUID[])}
   */
  @Test
  public void testFindTenantProfilesByIds_thenReturnEmpty() {
    // Arrange
    when(tenantProfileDao.findTenantProfilesByIds(Mockito.<TenantId>any(), Mockito.<UUID[]>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<TenantProfile> actualFindTenantProfilesByIdsResult = tenantProfileServiceImpl
        .findTenantProfilesByIds(ModelConstants.SYSTEM_TENANT, new UUID[]{ModelConstants.NULL_UUID});

    // Assert
    verify(tenantProfileDao).findTenantProfilesByIds(isA(TenantId.class), isA(UUID[].class));
    assertTrue(actualFindTenantProfilesByIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link TenantProfileServiceImpl#findTenantProfilesByIds(TenantId, UUID[])}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findTenantProfilesByIds(TenantId, UUID[])}
   */
  @Test
  public void testFindTenantProfilesByIds_thenThrowConstraintViolationException() {
    // Arrange
    when(tenantProfileDao.findTenantProfilesByIds(Mockito.<TenantId>any(), Mockito.<UUID[]>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> tenantProfileServiceImpl
        .findTenantProfilesByIds(ModelConstants.SYSTEM_TENANT, new UUID[]{ModelConstants.NULL_UUID}));
    verify(tenantProfileDao).findTenantProfilesByIds(isA(TenantId.class), isA(UUID[].class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#deleteTenantProfiles(TenantId)}.
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#deleteTenantProfiles(TenantId)}
   */
  @Test
  public void testDeleteTenantProfiles() {
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
   * Test {@link TenantProfileServiceImpl#deleteTenantProfiles(TenantId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#deleteTenantProfiles(TenantId)}
   */
  @Test
  public void testDeleteTenantProfiles_thenThrowConstraintViolationException() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));

    ArrayList<TenantProfile> data = new ArrayList<>();
    data.add(tenantProfile);
    PageData<TenantProfile> pageData = new PageData<>(data, 100, 100L, true);

    doThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Executing deleteTenantProfiles"))
        .when(tenantProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tenantProfileDao.findTenantProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> tenantProfileServiceImpl.deleteTenantProfiles(ModelConstants.SYSTEM_TENANT));
    verify(tenantProfile).getId();
    verify(tenantProfile).isDefault();
    verify(tenantProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(tenantProfileDao).findTenantProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link TenantProfileServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = tenantProfileServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        entityId);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    verify(entityId).getId();
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(tenantProfile, actualFindEntityResult.get());
  }

  /**
   * Test {@link TenantProfileServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantProfileCacheKey>any(),
        Mockito.<Supplier<TenantProfile>>any(), anyBoolean())).thenReturn(tenantProfile);

    // Act
    Optional<HasId<?>> actualFindEntityResult = tenantProfileServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantProfileCacheKey.class), isA(Supplier.class),
        eq(true));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(tenantProfile, actualFindEntityResult.get());
  }

  /**
   * Test {@link TenantProfileServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link TenantProfileServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.TENANT_PROFILE, (new TenantProfileServiceImpl()).getEntityType());
  }
}
