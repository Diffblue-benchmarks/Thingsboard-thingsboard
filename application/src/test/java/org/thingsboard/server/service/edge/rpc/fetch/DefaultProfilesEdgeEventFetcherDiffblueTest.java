package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.device.DeviceProfileService;

@ContextConfiguration(classes = {DefaultProfilesEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultProfilesEdgeEventFetcherDiffblueTest {
  @MockBean
  private AssetProfileService assetProfileService;

  @Autowired
  private DefaultProfilesEdgeEventFetcher defaultProfilesEdgeEventFetcher;

  @MockBean
  private DeviceProfileService deviceProfileService;

  /**
   * Test {@link DefaultProfilesEdgeEventFetcher#getPageLink(int)}.
   * <p>
   * Method under test: {@link DefaultProfilesEdgeEventFetcher#getPageLink(int)}
   */
  @Test
  @DisplayName("Test getPageLink(int)")
  void testGetPageLink() {
    // Arrange, Act and Assert
    assertNull(defaultProfilesEdgeEventFetcher.getPageLink(3));
  }

  /**
   * Test
   * {@link DefaultProfilesEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>Then return Data first EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultProfilesEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEdgeEvents(TenantId, Edge, PageLink); then return Data first EntityId is 'null'")
  void testFetchEdgeEvents_thenReturnDataFirstEntityIdIsNull() {
    // Arrange
    when(deviceProfileService.findDefaultDeviceProfile(Mockito.<TenantId>any())).thenReturn(new DeviceProfile());
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(new AssetProfile());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult = defaultProfilesEdgeEventFetcher.fetchEdgeEvents(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(assetProfileService).findDefaultAssetProfile(isA(TenantId.class));
    verify(deviceProfileService).findDefaultDeviceProfile(isA(TenantId.class));
    List<EdgeEvent> data = actualFetchEdgeEventsResult.getData();
    assertEquals(2, data.size());
    EdgeEvent getResult = data.get(0);
    assertNull(getResult.getBody());
    EdgeEvent getResult2 = data.get(1);
    assertNull(getResult2.getBody());
    assertNull(getResult.getUid());
    assertNull(getResult2.getUid());
    assertNull(getResult.getEntityId());
    assertNull(getResult2.getEntityId());
    assertNull(getResult.getUuidId());
    assertNull(getResult2.getUuidId());
    assertNull(getResult.getId());
    assertNull(getResult2.getId());
    assertNull(getResult.getEdgeId());
    assertNull(getResult2.getEdgeId());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(0L, getResult2.getCreatedTime());
    assertEquals(0L, getResult.getSeqId());
    assertEquals(0L, getResult2.getSeqId());
    assertEquals(1, actualFetchEdgeEventsResult.getTotalPages());
    assertEquals(2L, actualFetchEdgeEventsResult.getTotalElements());
    assertEquals(EdgeEventActionType.ADDED, getResult.getAction());
    assertEquals(EdgeEventActionType.ADDED, getResult2.getAction());
    assertEquals(EdgeEventType.ASSET_PROFILE, getResult2.getType());
    assertEquals(EdgeEventType.DEVICE_PROFILE, getResult.getType());
    assertFalse(actualFetchEdgeEventsResult.hasNext());
    assertSame(tenantId, getResult.getTenantId());
    assertSame(tenantId, getResult2.getTenantId());
  }

  /**
   * Test
   * {@link DefaultProfilesEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>Then return Data first EntityId is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultProfilesEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEdgeEvents(TenantId, Edge, PageLink); then return Data first EntityId is randomUUID")
  void testFetchEdgeEvents_thenReturnDataFirstEntityIdIsRandomUUID() {
    // Arrange
    UUID id = UUID.randomUUID();
    when(deviceProfileService.findDefaultDeviceProfile(Mockito.<TenantId>any()))
        .thenReturn(new DeviceProfile(new DeviceProfileId(id)));
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(new AssetProfile());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult = defaultProfilesEdgeEventFetcher.fetchEdgeEvents(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(assetProfileService).findDefaultAssetProfile(isA(TenantId.class));
    verify(deviceProfileService).findDefaultDeviceProfile(isA(TenantId.class));
    List<EdgeEvent> data = actualFetchEdgeEventsResult.getData();
    assertEquals(2, data.size());
    EdgeEvent getResult = data.get(0);
    assertNull(getResult.getBody());
    EdgeEvent getResult2 = data.get(1);
    assertNull(getResult2.getBody());
    assertNull(getResult.getUid());
    assertNull(getResult2.getUid());
    assertNull(getResult2.getEntityId());
    assertNull(getResult.getUuidId());
    assertNull(getResult2.getUuidId());
    assertNull(getResult.getId());
    assertNull(getResult2.getId());
    assertNull(getResult.getEdgeId());
    assertNull(getResult2.getEdgeId());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(0L, getResult2.getCreatedTime());
    assertEquals(0L, getResult.getSeqId());
    assertEquals(0L, getResult2.getSeqId());
    assertEquals(1, actualFetchEdgeEventsResult.getTotalPages());
    assertEquals(2L, actualFetchEdgeEventsResult.getTotalElements());
    assertEquals(EdgeEventActionType.ADDED, getResult.getAction());
    assertEquals(EdgeEventActionType.ADDED, getResult2.getAction());
    assertEquals(EdgeEventType.ASSET_PROFILE, getResult2.getType());
    assertEquals(EdgeEventType.DEVICE_PROFILE, getResult.getType());
    assertFalse(actualFetchEdgeEventsResult.hasNext());
    assertSame(tenantId, getResult.getTenantId());
    assertSame(tenantId, getResult2.getTenantId());
    assertSame(id, getResult.getEntityId());
  }
}
