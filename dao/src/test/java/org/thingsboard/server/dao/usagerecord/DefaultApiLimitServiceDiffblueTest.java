package org.thingsboard.server.dao.usagerecord;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
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
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;

@ContextConfiguration(classes = {DefaultApiLimitService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DefaultApiLimitServiceDiffblueTest {
  @Autowired
  private DefaultApiLimitService defaultApiLimitService;

  @MockBean
  private EntityService entityService;

  @MockBean
  private TbTenantProfileCache tbTenantProfileCache;

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  public void testCheckEntitiesLimit() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    boolean actualCheckEntitiesLimitResult = defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.TENANT);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(actualCheckEntitiesLimitResult);
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  public void testCheckEntitiesLimit2() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile(new TenantProfile()));

    // Act
    boolean actualCheckEntitiesLimitResult = defaultApiLimitService.checkEntitiesLimit(new TenantId(UUID.randomUUID()),
        EntityType.TENANT);

    // Assert
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualCheckEntitiesLimitResult);
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}
   * {@link TbTenantProfileCache#get(TenantId)} return
   * {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  public void testCheckEntitiesLimit_givenTbTenantProfileCacheGetReturnTenantProfile() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    // Act
    boolean actualCheckEntitiesLimitResult = defaultApiLimitService.checkEntitiesLimit(new TenantId(UUID.randomUUID()),
        EntityType.TENANT);

    // Assert
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualCheckEntitiesLimitResult);
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  public void testCheckEntitiesLimit_givenTbTenantProfileCache_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(defaultApiLimitService.checkEntitiesLimit(null, EntityType.TENANT));
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  public void testCheckEntitiesLimit_thenThrowIllegalArgumentException() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultApiLimitService.checkEntitiesLimit(new TenantId(UUID.randomUUID()), EntityType.TENANT));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  public void testGetLimit() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile(new TenantProfile()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Function<DefaultTenantProfileConfiguration, Number> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<DefaultTenantProfileConfiguration>any())).thenReturn(Integer.valueOf(1));

    // Act
    long actualLimit = defaultApiLimitService.getLimit(tenantId, extractor);

    // Assert
    verify(extractor).apply(isA(DefaultTenantProfileConfiguration.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertEquals(1L, actualLimit);
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  public void testGetLimit_givenIllegalArgumentExceptionWithFoo() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Function<DefaultTenantProfileConfiguration, Number> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<DefaultTenantProfileConfiguration>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultApiLimitService.getLimit(tenantId, extractor));
    verify(extractor).apply(isA(DefaultTenantProfileConfiguration.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}
   * {@link TbTenantProfileCache#get(TenantId)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  public void testGetLimit_givenTbTenantProfileCacheGetReturnNull() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultApiLimitService.getLimit(new TenantId(UUID.randomUUID()), mock(Function.class)));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}
   * {@link TbTenantProfileCache#get(TenantId)} return
   * {@link TenantProfile#TenantProfile()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  public void testGetLimit_givenTbTenantProfileCacheGetReturnTenantProfile_thenReturnOne() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Function<DefaultTenantProfileConfiguration, Number> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<DefaultTenantProfileConfiguration>any())).thenReturn(Integer.valueOf(1));

    // Act
    long actualLimit = defaultApiLimitService.getLimit(tenantId, extractor);

    // Assert
    verify(extractor).apply(isA(DefaultTenantProfileConfiguration.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertEquals(1L, actualLimit);
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  public void testGetLimit_givenTbTenantProfileCache_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, defaultApiLimitService.getLimit(null, mock(Function.class)));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   * <ul>
   *   <li>Then calls {@link TenantProfile#getDefaultProfileConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  public void testGetLimit_thenCallsGetDefaultProfileConfiguration() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getDefaultProfileConfiguration()).thenThrow(new IllegalArgumentException("foo"));
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultApiLimitService.getLimit(new TenantId(UUID.randomUUID()), mock(Function.class)));
    verify(tenantProfile).getDefaultProfileConfiguration();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   * <ul>
   *   <li>Then {@link ModelConstants#SYSTEM_TENANT} Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  public void testGetLimit_thenSystem_tenantIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    long actualLimit = defaultApiLimitService.getLimit(tenantId, mock(Function.class));

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(0L, actualLimit);
  }
}
