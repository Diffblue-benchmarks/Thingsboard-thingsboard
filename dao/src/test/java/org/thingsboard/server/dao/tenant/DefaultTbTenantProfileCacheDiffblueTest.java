package org.thingsboard.server.dao.tenant;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import java.util.function.Consumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {DefaultTbTenantProfileCache.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
public class DefaultTbTenantProfileCacheDiffblueTest {
  @Autowired
  private DefaultTbTenantProfileCache defaultTbTenantProfileCache;

  @MockBean
  private TenantProfileService tenantProfileService;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link DefaultTbTenantProfileCache#get(TenantId)} with {@code tenantId}.
   * <ul>
   *   <li>Then return {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#get(TenantId)}
   */
  @Test
  public void testGetWithTenantId_thenReturnTenantProfile() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    when(tenantProfileService.findTenantProfileById(Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(tenantProfile);

    Tenant tenant = new Tenant();
    tenant.setTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(tenant);

    // Act
    TenantProfile actualGetResult = defaultTbTenantProfileCache.get(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileService).findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertSame(tenantProfile, actualGetResult);
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#get(TenantProfileId)} with
   * {@code tenantProfileId}.
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#get(TenantProfileId)}
   */
  @Test
  public void testGetWithTenantProfileId() {
    // Arrange
    when(tenantProfileService.findTenantProfileById(Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(null);

    // Act
    TenantProfile actualGetResult = defaultTbTenantProfileCache.get(mock(TenantProfileId.class));

    // Assert
    verify(tenantProfileService).findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#get(TenantProfileId)} with
   * {@code tenantProfileId}.
   * <ul>
   *   <li>Then return {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#get(TenantProfileId)}
   */
  @Test
  public void testGetWithTenantProfileId_thenReturnTenantProfile() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    when(tenantProfileService.findTenantProfileById(Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(tenantProfile);

    // Act
    TenantProfile actualGetResult = defaultTbTenantProfileCache.get(mock(TenantProfileId.class));

    // Assert
    verify(tenantProfileService).findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    assertSame(tenantProfile, actualGetResult);
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#get(TenantProfileId)} with
   * {@code tenantProfileId}.
   * <ul>
   *   <li>When {@link TenantProfileId#TenantProfileId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#get(TenantProfileId)}
   */
  @Test
  public void testGetWithTenantProfileId_whenTenantProfileIdWithIdIsNull_uuid_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(defaultTbTenantProfileCache.get(new TenantProfileId(ModelConstants.NULL_UUID)));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#put(TenantProfile)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TenantProfile} {@link TenantProfile#getId()} return
   * {@code null}.</li>
   *   <li>Then calls {@link TenantProfile#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#put(TenantProfile)}
   */
  @Test
  public void testPut_givenNull_whenTenantProfileGetIdReturnNull_thenCallsGetId() {
    // Arrange
    TenantProfile profile = mock(TenantProfile.class);
    when(profile.getId()).thenReturn(null);

    // Act
    defaultTbTenantProfileCache.put(profile);

    // Assert that nothing has changed
    verify(profile).getId();
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#put(TenantProfile)}.
   * <ul>
   *   <li>Given {@link TenantProfileId#TenantProfileId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#put(TenantProfile)}
   */
  @Test
  public void testPut_givenTenantProfileIdWithIdIsNull_uuid() {
    // Arrange
    TenantProfile profile = mock(TenantProfile.class);
    when(profile.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));

    // Act
    defaultTbTenantProfileCache.put(profile);

    // Assert
    verify(profile, atLeast(1)).getId();
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantProfileId)} with
   * {@code profileId}.
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#evict(TenantProfileId)}
   */
  @Test
  public void testEvictWithProfileId() {
    // Arrange
    when(tenantProfileService.findTenantProfileById(Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(new TenantProfile());

    // Act
    defaultTbTenantProfileCache.evict(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantProfileService).findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantProfileId)} with
   * {@code profileId}.
   * <ul>
   *   <li>Given {@link TenantProfileService}
   * {@link TenantProfileService#findTenantProfileById(TenantId, TenantProfileId)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#evict(TenantProfileId)}
   */
  @Test
  public void testEvictWithProfileId_givenTenantProfileServiceFindTenantProfileByIdReturnNull() {
    // Arrange
    when(tenantProfileService.findTenantProfileById(Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(null);

    // Act
    defaultTbTenantProfileCache.evict(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantProfileService).findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantId)} with
   * {@code tenantId}.
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#evict(TenantId)}
   */
  @Test
  public void testEvictWithTenantId() {
    // Arrange
    when(tenantProfileService.findTenantProfileById(Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(new TenantProfile());

    Tenant tenant = new Tenant();
    tenant.setTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(tenant);

    // Act
    defaultTbTenantProfileCache.evict(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileService).findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantId)} with
   * {@code tenantId}.
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#evict(TenantId)}
   */
  @Test
  public void testEvictWithTenantId2() {
    // Arrange
    when(tenantProfileService.findTenantProfileById(Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(null);

    Tenant tenant = new Tenant();
    tenant.setTenantProfileId(new TenantProfileId(UUID.randomUUID()));
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(tenant);

    // Act
    defaultTbTenantProfileCache.evict(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileService).findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantId)} with
   * {@code tenantId}.
   * <ul>
   *   <li>Given {@link TenantProfileService}
   * {@link TenantProfileService#findTenantProfileById(TenantId, TenantProfileId)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#evict(TenantId)}
   */
  @Test
  public void testEvictWithTenantId_givenTenantProfileServiceFindTenantProfileByIdReturnNull() {
    // Arrange
    when(tenantProfileService.findTenantProfileById(Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(null);

    Tenant tenant = new Tenant();
    tenant.setTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(tenant);

    // Act
    defaultTbTenantProfileCache.evict(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileService).findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTbTenantProfileCache#evict(TenantId)} with
   * {@code tenantId}.
   * <ul>
   *   <li>Given {@link TenantService}
   * {@link TenantService#findTenantById(TenantId)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbTenantProfileCache#evict(TenantId)}
   */
  @Test
  public void testEvictWithTenantId_givenTenantServiceFindTenantByIdReturnNull() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);

    // Act
    defaultTbTenantProfileCache.evict(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId, Consumer)}.
   * <p>
   * Method under test:
   * {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId, Consumer)}
   */
  @Test
  public void testAddListener() {
    // Arrange
    when(tenantProfileService.findTenantProfileById(Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(new TenantProfile());

    Tenant tenant = new Tenant();
    tenant.setTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(tenant);

    // Act
    defaultTbTenantProfileCache.addListener(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        defaultTbTenantProfileCache::notifyTenantListeners);

    // Assert
    verify(tenantProfileService).findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId, Consumer)}.
   * <ul>
   *   <li>Given {@link TenantProfileService}
   * {@link TenantProfileService#findTenantProfileById(TenantId, TenantProfileId)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId, Consumer)}
   */
  @Test
  public void testAddListener_givenTenantProfileServiceFindTenantProfileByIdReturnNull() {
    // Arrange
    when(tenantProfileService.findTenantProfileById(Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(null);

    Tenant tenant = new Tenant();
    tenant.setTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(tenant);

    // Act
    defaultTbTenantProfileCache.addListener(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        defaultTbTenantProfileCache::notifyTenantListeners);

    // Assert
    verify(tenantProfileService).findTenantProfileById(isA(TenantId.class), isA(TenantProfileId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId, Consumer)}.
   * <ul>
   *   <li>Given {@link TenantService}
   * {@link TenantService#findTenantById(TenantId)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbTenantProfileCache#addListener(TenantId, EntityId, Consumer)}
   */
  @Test
  public void testAddListener_givenTenantServiceFindTenantByIdReturnNull() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);

    // Act
    defaultTbTenantProfileCache.addListener(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        defaultTbTenantProfileCache::notifyTenantListeners);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
  }
}
