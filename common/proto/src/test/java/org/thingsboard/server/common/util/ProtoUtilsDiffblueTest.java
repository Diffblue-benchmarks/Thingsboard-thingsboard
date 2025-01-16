package org.thingsboard.server.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;
import org.thingsboard.server.common.data.DeviceProfileType;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.TenantProfileType;
import org.thingsboard.server.common.data.device.data.DeviceConfiguration;
import org.thingsboard.server.common.data.device.data.DeviceData;
import org.thingsboard.server.common.data.device.data.DeviceTransportConfiguration;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.common.data.sync.vc.RepositoryAuthMethod;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.msg.MsgType;
import org.thingsboard.server.common.msg.ToDeviceActorNotificationMsg;
import org.thingsboard.server.common.msg.edge.EdgeEventUpdateMsg;
import org.thingsboard.server.common.msg.edge.EdgeHighPriorityMsg;
import org.thingsboard.server.common.msg.edge.FromEdgeSyncResponse;
import org.thingsboard.server.common.msg.edge.ToEdgeSyncRequest;
import org.thingsboard.server.common.msg.plugin.ComponentLifecycleMsg;
import org.thingsboard.server.gen.transport.TransportProtos;

class ProtoUtilsDiffblueTest {
  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityType is {@code WIDGETS_BUNDLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityType is 'WIDGETS_BUNDLE'")
  void testToProtoWithApiUsageState_thenReturnEntityTypeIsWidgetsBundle() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.WIDGETS_BUNDLE);
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(alarmId);
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(alarmId).getEntityType();
    verify(apiUsageState, atLeast(1)).getId();
    verify(alarmId, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(TransportProtos.EntityTypeProto.WIDGETS_BUNDLE, actualToProtoResult.getEntityType());
    assertEquals(Short.SIZE, actualToProtoResult.getEntityTypeValue());
  }

  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityTypeValue is eleven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityTypeValue is eleven")
  void testToProtoWithApiUsageState_thenReturnEntityTypeValueIsEleven() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.RULE_CHAIN);
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(alarmId);
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(alarmId).getEntityType();
    verify(apiUsageState, atLeast(1)).getId();
    verify(alarmId, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(11, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.RULE_CHAIN, actualToProtoResult.getEntityType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityTypeValue is fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityTypeValue is fifteen")
  void testToProtoWithApiUsageState_thenReturnEntityTypeValueIsFifteen() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.ENTITY_VIEW);
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(alarmId);
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(alarmId).getEntityType();
    verify(apiUsageState, atLeast(1)).getId();
    verify(alarmId, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(15, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.ENTITY_VIEW, actualToProtoResult.getEntityType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityTypeValue is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityTypeValue is five")
  void testToProtoWithApiUsageState_thenReturnEntityTypeValueIsFive() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.ASSET);
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(alarmId);
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(alarmId).getEntityType();
    verify(apiUsageState, atLeast(1)).getId();
    verify(alarmId, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(5, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.ASSET, actualToProtoResult.getEntityType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityTypeValue is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityTypeValue is four")
  void testToProtoWithApiUsageState_thenReturnEntityTypeValueIsFour() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(alarmId);
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(alarmId).getEntityType();
    verify(apiUsageState, atLeast(1)).getId();
    verify(alarmId, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(4, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.DASHBOARD, actualToProtoResult.getEntityType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityTypeValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityTypeValue is one")
  void testToProtoWithApiUsageState_thenReturnEntityTypeValueIsOne() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(alarmId);
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(alarmId).getEntityType();
    verify(apiUsageState, atLeast(1)).getId();
    verify(alarmId, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(1, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.TENANT, actualToProtoResult.getEntityType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityTypeValue is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityTypeValue is seven")
  void testToProtoWithApiUsageState_thenReturnEntityTypeValueIsSeven() {
    // Arrange
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(apiUsageState, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(7, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.ALARM, actualToProtoResult.getEntityType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityTypeValue is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityTypeValue is six")
  void testToProtoWithApiUsageState_thenReturnEntityTypeValueIsSix() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.DEVICE);
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(alarmId);
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(alarmId).getEntityType();
    verify(apiUsageState, atLeast(1)).getId();
    verify(alarmId, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(6, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.DEVICE, actualToProtoResult.getEntityType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityTypeValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityTypeValue is three")
  void testToProtoWithApiUsageState_thenReturnEntityTypeValueIsThree() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.USER);
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(alarmId);
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(alarmId).getEntityType();
    verify(apiUsageState, atLeast(1)).getId();
    verify(alarmId, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(3, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.USER, actualToProtoResult.getEntityType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityTypeValue is twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityTypeValue is twelve")
  void testToProtoWithApiUsageState_thenReturnEntityTypeValueIsTwelve() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(alarmId);
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(alarmId).getEntityType();
    verify(apiUsageState, atLeast(1)).getId();
    verify(alarmId, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(12, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.RULE_NODE, actualToProtoResult.getEntityType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityTypeValue is twenty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityTypeValue is twenty-three")
  void testToProtoWithApiUsageState_thenReturnEntityTypeValueIsTwentyThree() {
    // Arrange
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(new ApiUsageStateId(UUID.randomUUID()));
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(apiUsageState, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(23, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.API_USAGE_STATE, actualToProtoResult.getEntityType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ApiUsageState)} with {@code ApiUsageState}.
   * <ul>
   *   <li>Then return EntityTypeValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ApiUsageState)}
   */
  @Test
  @DisplayName("Test toProto(ApiUsageState) with 'ApiUsageState'; then return EntityTypeValue is two")
  void testToProtoWithApiUsageState_thenReturnEntityTypeValueIsTwo() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    ApiUsageStateId apiUsageStateId = mock(ApiUsageStateId.class);
    when(apiUsageStateId.getId()).thenReturn(UUID.randomUUID());
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    when(apiUsageState.getCreatedTime()).thenReturn(1L);
    when(apiUsageState.getEntityId()).thenReturn(alarmId);
    when(apiUsageState.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(apiUsageState.getId()).thenReturn(apiUsageStateId);

    // Act
    TransportProtos.ApiUsageStateProto actualToProtoResult = ProtoUtils.toProto(apiUsageState);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState, atLeast(1)).getEntityId();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState, atLeast(1)).getTenantId();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).getCreatedTime();
    verify(alarmId).getEntityType();
    verify(apiUsageState, atLeast(1)).getId();
    verify(alarmId, atLeast(1)).getId();
    verify(apiUsageStateId, atLeast(1)).getId();
    assertEquals(2, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.CUSTOMER, actualToProtoResult.getEntityType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'")
  void testToProtoWithAttributeKvEntry() {
    // Arrange and Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(10, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(10, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(2, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(8);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(9);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    TransportProtos.AttributeValueProto defaultInstanceForType4 = actualToProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult9, getResult7.getContainingOneof());
    assertSame(getResult10, getResult8.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>Given {@code BOOLEAN}.</li>
   *   <li>Then return SerializedSize is thirteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; given 'BOOLEAN'; then return SerializedSize is thirteen")
  void testToProtoWithAttributeKvEntry_givenBoolean_thenReturnSerializedSizeIsThirteen() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    Optional<Boolean> ofResult = Optional.of(true);
    when(attributeKvEntry.getBooleanValue()).thenReturn(ofResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getBooleanValue();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    assertEquals(0, actualToProtoResult.getTypeValue());
    assertEquals(13, actualToProtoResult.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.BOOLEAN_V, actualToProtoResult.getType());
    assertTrue(actualToProtoResult.getBoolV());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>Given {@code LONG}.</li>
   *   <li>Then return SerializedSize is fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; given 'LONG'; then return SerializedSize is fifteen")
  void testToProtoWithAttributeKvEntry_givenLong_thenReturnSerializedSizeIsFifteen() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(attributeKvEntry.getLongValue()).thenReturn(ofResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.LONG);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry, atLeast(1)).getLongValue();
    assertEquals(1, actualToProtoResult.getTypeValue());
    assertEquals(15, actualToProtoResult.getSerializedSize());
    assertEquals(1L, actualToProtoResult.getLongV());
    assertEquals(TransportProtos.KeyValueType.LONG_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>Given {@link Optional} with ten.</li>
   *   <li>Then return DoubleV is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; given Optional with ten; then return DoubleV is ten")
  void testToProtoWithAttributeKvEntry_givenOptionalWithTen_thenReturnDoubleVIsTen() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Double> ofResult = Optional.<Double>of(10.0d);
    when(attributeKvEntry.getDoubleValue()).thenReturn(ofResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.DOUBLE);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry, atLeast(1)).getDoubleValue();
    verify(attributeKvEntry).getKey();
    assertEquals(10.0d, actualToProtoResult.getDoubleV());
    assertEquals(2, actualToProtoResult.getTypeValue());
    assertEquals(22, actualToProtoResult.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.DOUBLE_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>Then return AllFields size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return AllFields size is three")
  void testToProtoWithAttributeKvEntry_thenReturnAllFieldsSizeIsThree() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    Optional<Boolean> emptyResult = Optional.empty();
    when(attributeKvEntry.getBooleanValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry, atLeast(1)).getBooleanValue();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    assertEquals(0, actualToProtoResult.getTypeValue());
    assertEquals(3, actualToProtoResult.getAllFields().size());
    assertEquals(9, actualToProtoResult.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.BOOLEAN_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>Then return LongV is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return LongV is forty-two")
  void testToProtoWithAttributeKvEntry_thenReturnLongVIsFortyTwo() {
    // Arrange and Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new LongDataEntry("Key", 42L)));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(10, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(10, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(2, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    assertEquals(42L, actualToProtoResult.getLongV());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(8);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(9);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    TransportProtos.AttributeValueProto defaultInstanceForType4 = actualToProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult9, getResult7.getContainingOneof());
    assertSame(getResult10, getResult8.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>Then return SerializedSize is seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return SerializedSize is seventeen")
  void testToProtoWithAttributeKvEntry_thenReturnSerializedSizeIsSeventeen() {
    // Arrange and Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(new JsonDataEntry("Key", "42"), 1L, 1L));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(10, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(10, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    assertEquals(17, actualToProtoResult.getSerializedSize());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(2, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(8);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(9);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    TransportProtos.AttributeValueProto defaultInstanceForType4 = actualToProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult9, getResult7.getContainingOneof());
    assertSame(getResult10, getResult8.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>Then return SerializedSize is twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return SerializedSize is twenty")
  void testToProtoWithAttributeKvEntry_thenReturnSerializedSizeIsTwenty() {
    // Arrange and Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new DoubleDataEntry("Key", 10.0d)));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(10, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(10, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(2, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    assertEquals(20, actualToProtoResult.getSerializedSize());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(8);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(9);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    TransportProtos.AttributeValueProto defaultInstanceForType4 = actualToProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult9, getResult7.getContainingOneof());
    assertSame(getResult10, getResult8.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>Then return TypeValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; then return TypeValue is three")
  void testToProtoWithAttributeKvEntry_thenReturnTypeValueIsThree() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<String> emptyResult = Optional.empty();
    when(attributeKvEntry.getStrValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.STRING);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry, atLeast(1)).getStrValue();
    assertEquals(11, actualToProtoResult.getSerializedSize());
    assertEquals(3, actualToProtoResult.getTypeValue());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertEquals(TransportProtos.KeyValueType.STRING_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>When {@link AttributeKvEntry} {@link KvEntry#getDoubleValue()} return
   * empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; when AttributeKvEntry getDoubleValue() return empty")
  void testToProtoWithAttributeKvEntry_whenAttributeKvEntryGetDoubleValueReturnEmpty() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Double> emptyResult = Optional.empty();
    when(attributeKvEntry.getDoubleValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.DOUBLE);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry, atLeast(1)).getDoubleValue();
    verify(attributeKvEntry).getKey();
    assertEquals(11, actualToProtoResult.getSerializedSize());
    assertEquals(2, actualToProtoResult.getTypeValue());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertEquals(TransportProtos.KeyValueType.DOUBLE_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>When {@link AttributeKvEntry} {@link KvEntry#getLongValue()} return
   * empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; when AttributeKvEntry getLongValue() return empty")
  void testToProtoWithAttributeKvEntry_whenAttributeKvEntryGetLongValueReturnEmpty() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Long> emptyResult = Optional.empty();
    when(attributeKvEntry.getLongValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getVersion()).thenReturn(1L);
    when(attributeKvEntry.getDataType()).thenReturn(DataType.LONG);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getLastUpdateTs()).thenReturn(1L);

    // Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils.toProto(attributeKvEntry);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getVersion();
    verify(attributeKvEntry).getLastUpdateTs();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry, atLeast(1)).getLongValue();
    assertEquals(1, actualToProtoResult.getTypeValue());
    assertEquals(11, actualToProtoResult.getSerializedSize());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertEquals(TransportProtos.KeyValueType.LONG_V, actualToProtoResult.getType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>When {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with
   * {@code Key} and value is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; when BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'")
  void testToProtoWithAttributeKvEntry_whenBooleanDataEntryWithKeyAndValueIsTrue() {
    // Arrange and Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new BooleanDataEntry("Key", true)));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(10, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(10, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(2, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(8);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(9);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    TransportProtos.AttributeValueProto defaultInstanceForType4 = actualToProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult9, getResult7.getContainingOneof());
    assertSame(getResult10, getResult8.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key}
   * and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; when JsonDataEntry(String, String) with 'Key' and value is '42'")
  void testToProtoWithAttributeKvEntry_whenJsonDataEntryWithKeyAndValueIs42() {
    // Arrange and Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(10, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(10, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(2, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(8);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(9);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    TransportProtos.AttributeValueProto defaultInstanceForType4 = actualToProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult9, getResult7.getContainingOneof());
    assertSame(getResult10, getResult8.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(AttributeKvEntry)} with
   * {@code AttributeKvEntry}.
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key}
   * and value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(AttributeKvEntry)}
   */
  @Test
  @DisplayName("Test toProto(AttributeKvEntry) with 'AttributeKvEntry'; when JsonDataEntry(String, String) with 'Key' and value is 'null'")
  void testToProtoWithAttributeKvEntry_whenJsonDataEntryWithKeyAndValueIsNull() {
    // Arrange and Act
    TransportProtos.AttributeValueProto actualToProtoResult = ProtoUtils
        .toProto(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", null)));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(10, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(10, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(2, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(8);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(9);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    TransportProtos.AttributeValueProto defaultInstanceForType4 = actualToProtoResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult9, getResult7.getContainingOneof());
    assertSame(getResult10, getResult8.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'")
  void testToProtoWithComponentLifecycleMsg() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'")
  void testToProtoWithComponentLifecycleMsg2() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is five")
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsFive() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AssetId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(5, actualToProtoResult.getEntityTypeValue());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.EntityTypeProto.ASSET, actualToProtoResult.getEntityType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is four")
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsFour() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new DashboardId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(4, actualToProtoResult.getEntityTypeValue());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.EntityTypeProto.DASHBOARD, actualToProtoResult.getEntityType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is six")
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsSix() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new DeviceId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(6, actualToProtoResult.getEntityTypeValue());
    assertEquals(TransportProtos.EntityTypeProto.DEVICE, actualToProtoResult.getEntityType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is thirty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is thirty-six")
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsThirtySix() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new DomainId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(36, actualToProtoResult.getEntityTypeValue());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.EntityTypeProto.DOMAIN, actualToProtoResult.getEntityType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is twenty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is twenty-one")
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsTwentyOne() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new DeviceProfileId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(21, actualToProtoResult.getEntityTypeValue());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.EntityTypeProto.DEVICE_PROFILE, actualToProtoResult.getEntityType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is twenty-three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is twenty-three")
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsTwentyThree() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new ApiUsageStateId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(23, actualToProtoResult.getEntityTypeValue());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.EntityTypeProto.API_USAGE_STATE, actualToProtoResult.getEntityType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is twenty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is twenty-two")
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsTwentyTwo() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new AssetProfileId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(22, actualToProtoResult.getEntityTypeValue());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.EntityTypeProto.ASSET_PROFILE, actualToProtoResult.getEntityType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EntityTypeValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EntityTypeValue is two")
  void testToProtoWithComponentLifecycleMsg_thenReturnEntityTypeValueIsTwo() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new CustomerId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(2, actualToProtoResult.getEntityTypeValue());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.EntityTypeProto.CUSTOMER, actualToProtoResult.getEntityType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is five")
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsFive() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.STOPPED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(5, actualToProtoResult.getEventValue());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.ComponentLifecycleEvent.STOPPED, actualToProtoResult.getEvent());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is four")
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsFour() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.UPDATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(4, actualToProtoResult.getEventValue());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.ComponentLifecycleEvent.UPDATED, actualToProtoResult.getEvent());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is one")
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsOne() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.STARTED));

    // Assert
    assertEquals(1, actualToProtoResult.getEventValue());
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.ComponentLifecycleEvent.STARTED, actualToProtoResult.getEvent());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is seven")
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsSeven() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.FAILED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(7, actualToProtoResult.getEventValue());
    assertEquals(TransportProtos.ComponentLifecycleEvent.FAILED, actualToProtoResult.getEvent());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is six")
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsSix() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils
        .toProto(new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.DELETED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(6, actualToProtoResult.getEventValue());
    assertEquals(TransportProtos.ComponentLifecycleEvent.DELETED, actualToProtoResult.getEvent());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is three")
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsThree() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.SUSPENDED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(3, actualToProtoResult.getEventValue());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.ComponentLifecycleEvent.SUSPENDED, actualToProtoResult.getEvent());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(ComponentLifecycleMsg)} with
   * {@code ComponentLifecycleMsg}.
   * <ul>
   *   <li>Then return EventValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test toProto(ComponentLifecycleMsg) with 'ComponentLifecycleMsg'; then return EventValue is two")
  void testToProtoWithComponentLifecycleMsg_thenReturnEventValueIsTwo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.ComponentLifecycleMsgProto actualToProtoResult = ProtoUtils.toProto(
        new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.ACTIVATED));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(2, actualToProtoResult.getEventValue());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(6, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertEquals(TransportProtos.ComponentLifecycleEvent.ACTIVATED, actualToProtoResult.getEvent());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(5);
    Descriptors.EnumDescriptor enumType = getResult6.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(9));
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    TransportProtos.ComponentLifecycleMsgProto defaultInstanceForType4 = actualToProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceCredentials)} with
   * {@code DeviceCredentials}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test toProto(DeviceCredentials) with 'DeviceCredentials'")
  void testToProtoWithDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsValue("42");
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsId("42");
    deviceCredentials.setId(new DeviceCredentialsId(UUID.randomUUID()));

    // Act
    TransportProtos.DeviceCredentialsProto actualToProtoResult = ProtoUtils.toProto(deviceCredentials);

    // Assert
    TransportProtos.DeviceCredentialsProto defaultInstanceForType = actualToProtoResult.getDefaultInstanceForType();
    ByteString credentialsIdBytes = defaultInstanceForType.getCredentialsIdBytes();
    assertEquals("", credentialsIdBytes.toStringUtf8());
    assertEquals("42", actualToProtoResult.getCredentialsValue());
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(9, fields.size());
    assertFalse(credentialsIdBytes.iterator().hasNext());
    assertTrue(credentialsIdBytes.isEmpty());
    assertTrue(actualToProtoResult.hasCredentialsValue());
    assertEquals(credentialsIdBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(credentialsIdBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(credentialsIdBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(7).toProto();
    assertEquals(credentialsIdBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(8).toProto();
    assertEquals(credentialsIdBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(credentialsIdBytes, toProtoResult.getExtendeeBytes());
    assertEquals(credentialsIdBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(credentialsIdBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(credentialsIdBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(credentialsIdBytes, toProtoResult.getJsonNameBytes());
    assertEquals(credentialsIdBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(credentialsIdBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(credentialsIdBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(credentialsIdBytes, toProtoResult.getTypeNameBytes());
    assertEquals(credentialsIdBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(credentialsIdBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(credentialsIdBytes, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(credentialsIdBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(credentialsIdBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(credentialsIdBytes, options.getCsharpNamespaceBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(credentialsIdBytes, options.getGoPackageBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(credentialsIdBytes, options.getObjcClassPrefixBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(credentialsIdBytes, options.getPhpClassPrefixBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(credentialsIdBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(credentialsIdBytes, options.getPhpNamespaceBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(credentialsIdBytes, options.getRubyPackageBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(credentialsIdBytes, options.getSwiftPrefixBytes());
    assertEquals(credentialsIdBytes, defaultInstanceForType.getCredentialsValueBytes());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceCredentials)} with
   * {@code DeviceCredentials}.
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.</li>
   *   <li>Then return AllFields size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test toProto(DeviceCredentials) with 'DeviceCredentials'; given 'ACCESS_TOKEN'; then return AllFields size is three")
  void testToProtoWithDeviceCredentials_givenAccessToken_thenReturnAllFieldsSizeIsThree() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsId("42");
    deviceCredentials.setId(new DeviceCredentialsId(UUID.randomUUID()));

    // Act and Assert
    assertEquals(3, ProtoUtils.toProto(deviceCredentials).getAllFields().size());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceCredentials)} with
   * {@code DeviceCredentials}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Version is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test toProto(DeviceCredentials) with 'DeviceCredentials'; given one; then return Version is one")
  void testToProtoWithDeviceCredentials_givenOne_thenReturnVersionIsOne() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setVersion(1L);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsId("42");
    deviceCredentials.setId(new DeviceCredentialsId(UUID.randomUUID()));

    // Act
    TransportProtos.DeviceCredentialsProto actualToProtoResult = ProtoUtils.toProto(deviceCredentials);

    // Assert
    assertEquals(1L, actualToProtoResult.getVersion());
    assertTrue(actualToProtoResult.hasVersion());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Given {@code DISABLED}.</li>
   *   <li>Then return AllFields size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; given 'DISABLED'; then return AllFields size is five")
  void testToProtoWithDeviceProfile_givenDisabled_thenReturnAllFieldsSizeIsFive() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    deviceProfile.setName("");

    // Act and Assert
    assertEquals(5, ProtoUtils.toProto(deviceProfile).getAllFields().size());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return AllFields size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; given 'null'; then return AllFields size is six")
  void testToProtoWithDeviceProfile_givenNull_thenReturnAllFieldsSizeIsSix() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setProfileDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    deviceProfile.setDefaultRuleChainId(null);
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    deviceProfile.setName("");

    // Act and Assert
    assertEquals(6, ProtoUtils.toProto(deviceProfile).getAllFields().size());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Version is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; given one; then return Version is one")
  void testToProtoWithDeviceProfile_givenOne_thenReturnVersionIsOne() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setVersion(1L);
    deviceProfile.setProfileDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    deviceProfile.setDefaultRuleChainId(null);
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    deviceProfile.setName("");

    // Act
    TransportProtos.DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertEquals(1L, actualToProtoResult.getVersion());
    assertTrue(actualToProtoResult.hasVersion());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Then return AllFields size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; then return AllFields size is eight")
  void testToProtoWithDeviceProfile_thenReturnAllFieldsSizeIsEight() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultEdgeRuleChainId(new RuleChainId(UUID.randomUUID()));
    deviceProfile.setProfileDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    deviceProfile.setDefaultRuleChainId(null);
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    deviceProfile.setName("");

    // Act
    TransportProtos.DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertEquals(8, actualToProtoResult.getAllFields().size());
    assertTrue(actualToProtoResult.hasDefaultEdgeRuleChainIdLSB());
    assertTrue(actualToProtoResult.hasDefaultEdgeRuleChainIdMSB());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Then return DescriptionBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; then return DescriptionBytes toStringUtf8 is empty string")
  void testToProtoWithDeviceProfile_thenReturnDescriptionBytesToStringUtf8IsEmptyString() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultQueueName("Default Queue Name");
    deviceProfile.setProfileDataBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});
    deviceProfile.setDefaultRuleChainId(null);
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    deviceProfile.setName("");

    // Act
    TransportProtos.DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    ByteString descriptionBytes = actualToProtoResult.getDescriptionBytes();
    assertEquals("", descriptionBytes.toStringUtf8());
    ByteString defaultQueueNameBytes = actualToProtoResult.getDefaultQueueNameBytes();
    assertEquals("Default Queue Name", defaultQueueNameBytes.toStringUtf8());
    assertEquals("Default Queue Name", actualToProtoResult.getDefaultQueueName());
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(28, fields.size());
    assertFalse(defaultQueueNameBytes.isEmpty());
    assertFalse(descriptionBytes.iterator().hasNext());
    assertTrue(descriptionBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = defaultQueueNameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualToProtoResult.hasDefaultQueueName());
    assertEquals(descriptionBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(descriptionBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(descriptionBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(26).toProto();
    assertEquals(descriptionBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(27).toProto();
    assertEquals(descriptionBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(descriptionBytes, toProtoResult.getExtendeeBytes());
    assertEquals(descriptionBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(descriptionBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(descriptionBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(descriptionBytes, toProtoResult.getJsonNameBytes());
    assertEquals(descriptionBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(descriptionBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(descriptionBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(descriptionBytes, toProtoResult.getTypeNameBytes());
    assertEquals(descriptionBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(descriptionBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(descriptionBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(descriptionBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(descriptionBytes, options.getCsharpNamespaceBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(descriptionBytes, options.getGoPackageBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(descriptionBytes, options.getObjcClassPrefixBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(descriptionBytes, options.getPhpClassPrefixBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(descriptionBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(descriptionBytes, options.getPhpNamespaceBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(descriptionBytes, options.getRubyPackageBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(descriptionBytes, options.getSwiftPrefixBytes());
    TransportProtos.DeviceProfileProto defaultInstanceForType2 = actualToProtoResult.getDefaultInstanceForType();
    assertEquals(descriptionBytes, defaultInstanceForType2.getDefaultQueueNameBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getDescriptionBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getDeviceProfileData());
    assertEquals(descriptionBytes, defaultInstanceForType2.getImageBytes());
    assertEquals(descriptionBytes, actualToProtoResult.getImageBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(descriptionBytes, actualToProtoResult.getNameBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getProvisionDeviceKeyBytes());
    assertEquals(descriptionBytes, actualToProtoResult.getProvisionDeviceKeyBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getProvisionTypeBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getTransportTypeBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getTypeBytes());
    assertEquals('D', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('f', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link ProtoUtils#toProto(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Then return hasDefaultRuleChainIdLSB.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(DeviceProfile)}
   */
  @Test
  @DisplayName("Test toProto(DeviceProfile) with 'DeviceProfile'; then return hasDefaultRuleChainIdLSB")
  void testToProtoWithDeviceProfile_thenReturnHasDefaultRuleChainIdLSB() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultRuleChainId(new RuleChainId(UUID.randomUUID()));
    deviceProfile.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfile.setTransportType(DeviceTransportType.MQTT);
    deviceProfile.setType(DeviceProfileType.DEFAULT);
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    deviceProfile.setName("");

    // Act
    TransportProtos.DeviceProfileProto actualToProtoResult = ProtoUtils.toProto(deviceProfile);

    // Assert
    assertTrue(actualToProtoResult.hasDefaultRuleChainIdLSB());
    assertTrue(actualToProtoResult.hasDefaultRuleChainIdMSB());
  }

  /**
   * Test {@link ProtoUtils#toProto(EdgeEventUpdateMsg)} with
   * {@code EdgeEventUpdateMsg}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EdgeEventUpdateMsg)}
   */
  @Test
  @DisplayName("Test toProto(EdgeEventUpdateMsg) with 'EdgeEventUpdateMsg'")
  void testToProtoWithEdgeEventUpdateMsg() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TransportProtos.EdgeEventUpdateMsgProto actualToProtoResult = ProtoUtils
        .toProto(new EdgeEventUpdateMsg(tenantId, new EdgeId(UUID.randomUUID())));

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult2.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult4.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    TransportProtos.EdgeEventUpdateMsgProto defaultInstanceForType4 = actualToProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    assertEquals("", actualToProtoResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult4.getTypeName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    Descriptors.EnumDescriptor getResult5 = enumTypes.get(9);
    assertEquals("ComponentLifecycleEvent", getResult5.getName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("EdgeEventUpdateMsgProto", nameBytes.toStringUtf8());
    assertEquals("EdgeEventUpdateMsgProto", toProtoResult.getName());
    assertEquals("EdgeEventUpdateMsgProto", descriptorForType.getName());
    Descriptors.EnumDescriptor getResult6 = enumTypes.get(0);
    assertEquals("EntityTypeProto", getResult6.getName());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType5.getName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    Descriptors.Descriptor getResult7 = messageTypes.get(179);
    assertEquals("HousekeeperTaskProto", getResult7.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.EnumDescriptor getResult8 = enumTypes.get(8);
    assertEquals("ResponseStatus", getResult8.getName());
    Descriptors.Descriptor getResult9 = messageTypes.get(0);
    assertEquals("ServiceInfo", getResult9.getName());
    Descriptors.EnumDescriptor getResult10 = enumTypes.get(1);
    assertEquals("SessionEvent", getResult10.getName());
    Descriptors.Descriptor getResult11 = messageTypes.get(1);
    assertEquals("SystemInfoProto", getResult11.getName());
    Descriptors.Descriptor getResult12 = messageTypes.get(178);
    assertEquals("ToHousekeeperServiceMsg", getResult12.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("TransportProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("TransportProtos", options.getJavaOuterClassname());
    assertEquals("edgeIdLSB", toProtoResult7.getName());
    assertEquals("edgeIdLSB", getResult4.getJsonName());
    assertEquals("edgeIdLSB", getResult4.getName());
    assertEquals("edgeIdMSB", toProtoResult6.getName());
    assertEquals("edgeIdMSB", getResult3.getJsonName());
    assertEquals("edgeIdMSB", getResult3.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType5.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("queue.proto", nameBytes2.toStringUtf8());
    assertEquals("queue.proto", toProtoResult2.getName());
    assertEquals("queue.proto", file.getFullName());
    assertEquals("queue.proto", file.getName());
    assertEquals("tenantIdLSB", toProtoResult5.getName());
    assertEquals("tenantIdLSB", getResult2.getJsonName());
    assertEquals("tenantIdLSB", getResult2.getName());
    assertEquals("tenantIdMSB", toProtoResult4.getName());
    assertEquals("tenantIdMSB", getResult.getJsonName());
    assertEquals("tenantIdMSB", getResult.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("transport", packageBytes.toStringUtf8());
    assertEquals("transport", toProtoResult2.getPackage());
    assertEquals("transport", file.getPackage());
    assertEquals("transport.ComponentLifecycleEvent", getResult5.getFullName());
    assertEquals("transport.EdgeEventUpdateMsgProto", descriptorForType.getFullName());
    assertEquals("transport.EdgeEventUpdateMsgProto.edgeIdLSB", getResult4.getFullName());
    assertEquals("transport.EdgeEventUpdateMsgProto.edgeIdMSB", getResult3.getFullName());
    assertEquals("transport.EdgeEventUpdateMsgProto.tenantIdLSB", getResult2.getFullName());
    assertEquals("transport.EdgeEventUpdateMsgProto.tenantIdMSB", getResult.getFullName());
    assertEquals("transport.EntityTypeProto", getResult6.getFullName());
    assertEquals("transport.HousekeeperTaskProto", getResult7.getFullName());
    assertEquals("transport.ResponseStatus", getResult8.getFullName());
    assertEquals("transport.ServiceInfo", getResult9.getFullName());
    assertEquals("transport.SessionEvent", getResult10.getFullName());
    assertEquals("transport.SystemInfoProto", getResult11.getFullName());
    assertEquals("transport.ToHousekeeperServiceMsg", getResult12.getFullName());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult9.getContainingType());
    assertNull(getResult11.getContainingType());
    assertNull(getResult12.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult10.getContainingType());
    assertNull(getResult8.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult9.getIndex());
    assertEquals(0, getResult6.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualToProtoResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0L, defaultInstanceForType4.getEdgeIdLSB());
    assertEquals(0L, defaultInstanceForType4.getEdgeIdMSB());
    assertEquals(0L, defaultInstanceForType4.getTenantIdLSB());
    assertEquals(0L, defaultInstanceForType4.getTenantIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, descriptorForType4.getIndex());
    assertEquals(1, getResult11.getIndex());
    assertEquals(1, getResult10.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(10, toProtoResult2.getEnumTypeCount());
    assertEquals(10, descriptorForType5.getIndex());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    assertEquals(105, toProtoResult.getSerializedSize());
    assertEquals(11, descriptorForType2.getIndex());
    assertEquals(123, descriptorForType.getIndex());
    assertEquals(17, toProtoResult6.getSerializedSize());
    assertEquals(17, toProtoResult7.getSerializedSize());
    assertEquals(178, getResult12.getIndex());
    assertEquals(179, getResult7.getIndex());
    assertEquals(180, toProtoResult2.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    assertEquals(19, toProtoResult4.getSerializedSize());
    assertEquals(19, toProtoResult5.getSerializedSize());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, toProtoResult.getAllFields().size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, toProtoResult6.getNumber());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(36059, toProtoResult2.getSerializedSize());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult7.getNumber());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    assertEquals(4, actualToProtoResult.getAllFields().size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(55, options.getSerializedSize());
    assertEquals(6, toProtoResult2.getAllFields().size());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(8, getResult8.getIndex());
    assertEquals(9, getResult5.getIndex());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult4.hasTypeName());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType4.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult9.isExtendable());
    assertFalse(getResult11.isExtendable());
    assertFalse(getResult12.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult6.isClosed());
    assertFalse(getResult10.isClosed());
    assertFalse(getResult8.isClosed());
    assertFalse(getResult5.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType5.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType4.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualToProtoResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = defaultInstanceForType4.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(actualToProtoResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult9.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult11.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult12.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult9.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult11.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult12.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult9.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult11.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult12.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult9.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult11.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult12.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult9.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult11.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult12.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields2, defaultInstanceForType.getAllFields());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, features.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals('E', iteratorResult.next().byteValue());
    assertEquals('T', iteratorResult5.next().byteValue());
    assertEquals('d', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('q', iteratorResult2.next().byteValue());
    assertEquals('t', iteratorResult3.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult11.getFile());
    assertSame(file, getResult12.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult10.getFile());
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, getResult9.getOptions());
    assertSame(options4, getResult11.getOptions());
    assertSame(options4, getResult12.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Test {@link ProtoUtils#toProto(EdgeHighPriorityMsg)} with
   * {@code EdgeHighPriorityMsg}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>Then return AllFields size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EdgeHighPriorityMsg)}
   */
  @Test
  @DisplayName("Test toProto(EdgeHighPriorityMsg) with 'EdgeHighPriorityMsg'; given 'ADDED'; then return AllFields size is four")
  void testToProtoWithEdgeHighPriorityMsg_givenAdded_thenReturnAllFieldsSizeIsFour() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);
    edgeEvent.setType(EdgeEventType.ASSET);

    // Act and Assert
    assertEquals(4,
        ProtoUtils.toProto(new EdgeHighPriorityMsg(new TenantId(UUID.randomUUID()), edgeEvent)).getAllFields().size());
  }

  /**
   * Test {@link ProtoUtils#toProto(EdgeHighPriorityMsg)} with
   * {@code EdgeHighPriorityMsg}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then return AllFields size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EdgeHighPriorityMsg)}
   */
  @Test
  @DisplayName("Test toProto(EdgeHighPriorityMsg) with 'EdgeHighPriorityMsg'; given randomUUID; then return AllFields size is six")
  void testToProtoWithEdgeHighPriorityMsg_givenRandomUUID_thenReturnAllFieldsSizeIsSix() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setEntityId(UUID.randomUUID());
    edgeEvent.setAction(EdgeEventActionType.ADDED);
    edgeEvent.setType(EdgeEventType.ASSET);

    // Act
    TransportProtos.EdgeHighPriorityMsgProto actualToProtoResult = ProtoUtils
        .toProto(new EdgeHighPriorityMsg(new TenantId(UUID.randomUUID()), edgeEvent));

    // Assert
    assertEquals(6, actualToProtoResult.getAllFields().size());
    assertTrue(actualToProtoResult.hasEntityIdLSB());
    assertTrue(actualToProtoResult.hasEntityIdMSB());
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code ALARM}.</li>
   *   <li>Then return {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'ALARM'; then return 'ALARM'")
  void testToProtoWithEntityType_whenAlarm_thenReturnAlarm() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.ALARM, ProtoUtils.toProto(EntityType.ALARM));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code API_USAGE_STATE}.</li>
   *   <li>Then return {@code API_USAGE_STATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'API_USAGE_STATE'; then return 'API_USAGE_STATE'")
  void testToProtoWithEntityType_whenApiUsageState_thenReturnApiUsageState() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.API_USAGE_STATE, ProtoUtils.toProto(EntityType.API_USAGE_STATE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code ASSET_PROFILE}.</li>
   *   <li>Then return {@code ASSET_PROFILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'ASSET_PROFILE'; then return 'ASSET_PROFILE'")
  void testToProtoWithEntityType_whenAssetProfile_thenReturnAssetProfile() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.ASSET_PROFILE, ProtoUtils.toProto(EntityType.ASSET_PROFILE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code ASSET}.</li>
   *   <li>Then return {@code ASSET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'ASSET'; then return 'ASSET'")
  void testToProtoWithEntityType_whenAsset_thenReturnAsset() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.ASSET, ProtoUtils.toProto(EntityType.ASSET));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code CUSTOMER}.</li>
   *   <li>Then return {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'CUSTOMER'; then return 'CUSTOMER'")
  void testToProtoWithEntityType_whenCustomer_thenReturnCustomer() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.CUSTOMER, ProtoUtils.toProto(EntityType.CUSTOMER));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code DASHBOARD}.</li>
   *   <li>Then return {@code DASHBOARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'DASHBOARD'; then return 'DASHBOARD'")
  void testToProtoWithEntityType_whenDashboard_thenReturnDashboard() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.DASHBOARD, ProtoUtils.toProto(EntityType.DASHBOARD));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code DEVICE_PROFILE}.</li>
   *   <li>Then return {@code DEVICE_PROFILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'DEVICE_PROFILE'; then return 'DEVICE_PROFILE'")
  void testToProtoWithEntityType_whenDeviceProfile_thenReturnDeviceProfile() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.DEVICE_PROFILE, ProtoUtils.toProto(EntityType.DEVICE_PROFILE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code DEVICE}.</li>
   *   <li>Then return {@code DEVICE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'DEVICE'; then return 'DEVICE'")
  void testToProtoWithEntityType_whenDevice_thenReturnDevice() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.DEVICE, ProtoUtils.toProto(EntityType.DEVICE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code EDGE}.</li>
   *   <li>Then return {@code EDGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'EDGE'; then return 'EDGE'")
  void testToProtoWithEntityType_whenEdge_thenReturnEdge() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.EDGE, ProtoUtils.toProto(EntityType.EDGE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.</li>
   *   <li>Then return {@code ENTITY_VIEW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'ENTITY_VIEW'; then return 'ENTITY_VIEW'")
  void testToProtoWithEntityType_whenEntityView_thenReturnEntityView() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.ENTITY_VIEW, ProtoUtils.toProto(EntityType.ENTITY_VIEW));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.</li>
   *   <li>Then return {@code OTA_PACKAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'OTA_PACKAGE'; then return 'OTA_PACKAGE'")
  void testToProtoWithEntityType_whenOtaPackage_thenReturnOtaPackage() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.OTA_PACKAGE, ProtoUtils.toProto(EntityType.OTA_PACKAGE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code RPC}.</li>
   *   <li>Then return {@code RPC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'RPC'; then return 'RPC'")
  void testToProtoWithEntityType_whenRpc_thenReturnRpc() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.RPC, ProtoUtils.toProto(EntityType.RPC));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code RULE_CHAIN}.</li>
   *   <li>Then return {@code RULE_CHAIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'RULE_CHAIN'; then return 'RULE_CHAIN'")
  void testToProtoWithEntityType_whenRuleChain_thenReturnRuleChain() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.RULE_CHAIN, ProtoUtils.toProto(EntityType.RULE_CHAIN));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code RULE_NODE}.</li>
   *   <li>Then return {@code RULE_NODE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'RULE_NODE'; then return 'RULE_NODE'")
  void testToProtoWithEntityType_whenRuleNode_thenReturnRuleNode() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.RULE_NODE, ProtoUtils.toProto(EntityType.RULE_NODE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code TB_RESOURCE}.</li>
   *   <li>Then return {@code TB_RESOURCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'TB_RESOURCE'; then return 'TB_RESOURCE'")
  void testToProtoWithEntityType_whenTbResource_thenReturnTbResource() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.TB_RESOURCE, ProtoUtils.toProto(EntityType.TB_RESOURCE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code TENANT_PROFILE}.</li>
   *   <li>Then return {@code TENANT_PROFILE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'TENANT_PROFILE'; then return 'TENANT_PROFILE'")
  void testToProtoWithEntityType_whenTenantProfile_thenReturnTenantProfile() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.TENANT_PROFILE, ProtoUtils.toProto(EntityType.TENANT_PROFILE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code TENANT}.</li>
   *   <li>Then return {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'TENANT'; then return 'TENANT'")
  void testToProtoWithEntityType_whenTenant_thenReturnTenant() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.TENANT, ProtoUtils.toProto(EntityType.TENANT));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code USER}.</li>
   *   <li>Then return {@code USER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'USER'; then return 'USER'")
  void testToProtoWithEntityType_whenUser_thenReturnUser() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.USER, ProtoUtils.toProto(EntityType.USER));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.</li>
   *   <li>Then return {@code WIDGET_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'WIDGET_TYPE'; then return 'WIDGET_TYPE'")
  void testToProtoWithEntityType_whenWidgetType_thenReturnWidgetType() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.WIDGET_TYPE, ProtoUtils.toProto(EntityType.WIDGET_TYPE));
  }

  /**
   * Test {@link ProtoUtils#toProto(EntityType)} with {@code EntityType}.
   * <ul>
   *   <li>When {@code WIDGETS_BUNDLE}.</li>
   *   <li>Then return {@code WIDGETS_BUNDLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(EntityType)}
   */
  @Test
  @DisplayName("Test toProto(EntityType) with 'EntityType'; when 'WIDGETS_BUNDLE'; then return 'WIDGETS_BUNDLE'")
  void testToProtoWithEntityType_whenWidgetsBundle_thenReturnWidgetsBundle() {
    // Arrange, Act and Assert
    assertEquals(TransportProtos.EntityTypeProto.WIDGETS_BUNDLE, ProtoUtils.toProto(EntityType.WIDGETS_BUNDLE));
  }

  /**
   * Test {@link ProtoUtils#toProto(RepositorySettings)} with
   * {@code RepositorySettings}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(RepositorySettings)}
   */
  @Test
  @DisplayName("Test toProto(RepositorySettings) with 'RepositorySettings'")
  void testToProtoWithRepositorySettings() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyFileName("foo.txt");
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setRepositoryUri("");

    // Act
    TransportProtos.RepositorySettingsProto actualToProtoResult = ProtoUtils.toProto(repositorySettings);

    // Assert
    ByteString privateKeyFileNameBytes = actualToProtoResult.getPrivateKeyFileNameBytes();
    assertEquals("foo.txt", privateKeyFileNameBytes.toStringUtf8());
    assertEquals("foo.txt", actualToProtoResult.getPrivateKeyFileName());
    assertFalse(privateKeyFileNameBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = privateKeyFileNameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualToProtoResult.hasPrivateKeyFileName());
    assertEquals('f', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link ProtoUtils#toProto(RepositorySettings)} with
   * {@code RepositorySettings}.
   * <p>
   * Method under test: {@link ProtoUtils#toProto(RepositorySettings)}
   */
  @Test
  @DisplayName("Test toProto(RepositorySettings) with 'RepositorySettings'")
  void testToProtoWithRepositorySettings2() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyPassword("iloveyou");
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setRepositoryUri("");

    // Act
    TransportProtos.RepositorySettingsProto actualToProtoResult = ProtoUtils.toProto(repositorySettings);

    // Assert
    ByteString privateKeyPasswordBytes = actualToProtoResult.getPrivateKeyPasswordBytes();
    assertEquals("iloveyou", privateKeyPasswordBytes.toStringUtf8());
    assertEquals("iloveyou", actualToProtoResult.getPrivateKeyPassword());
    assertFalse(privateKeyPasswordBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = privateKeyPasswordBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualToProtoResult.hasPrivateKeyPassword());
    assertEquals('i', iteratorResult.next().byteValue());
    assertEquals('l', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link ProtoUtils#toProto(RepositorySettings)} with
   * {@code RepositorySettings}.
   * <ul>
   *   <li>Then return AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(RepositorySettings)}
   */
  @Test
  @DisplayName("Test toProto(RepositorySettings) with 'RepositorySettings'; then return AllFields size is one")
  void testToProtoWithRepositorySettings_thenReturnAllFieldsSizeIsOne() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setRepositoryUri("");

    // Act
    TransportProtos.RepositorySettingsProto actualToProtoResult = ProtoUtils.toProto(repositorySettings);

    // Assert
    assertEquals(1, actualToProtoResult.getAllFields().size());
    assertEquals(19, actualToProtoResult.getSerializedSize());
  }

  /**
   * Test {@link ProtoUtils#toProto(RepositorySettings)} with
   * {@code RepositorySettings}.
   * <ul>
   *   <li>Then return PasswordBytes toStringUtf8 is {@code iloveyou}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(RepositorySettings)}
   */
  @Test
  @DisplayName("Test toProto(RepositorySettings) with 'RepositorySettings'; then return PasswordBytes toStringUtf8 is 'iloveyou'")
  void testToProtoWithRepositorySettings_thenReturnPasswordBytesToStringUtf8IsIloveyou() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPassword("iloveyou");
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setRepositoryUri("");

    // Act
    TransportProtos.RepositorySettingsProto actualToProtoResult = ProtoUtils.toProto(repositorySettings);

    // Assert
    ByteString passwordBytes = actualToProtoResult.getPasswordBytes();
    assertEquals("iloveyou", passwordBytes.toStringUtf8());
    assertEquals("iloveyou", actualToProtoResult.getPassword());
    assertFalse(passwordBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = passwordBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualToProtoResult.hasPassword());
    assertEquals('i', iteratorResult.next().byteValue());
    assertEquals('l', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link ProtoUtils#toProto(TenantProfile)} with {@code TenantProfile}.
   * <ul>
   *   <li>Then return DescriptionBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(TenantProfile)}
   */
  @Test
  @DisplayName("Test toProto(TenantProfile) with 'TenantProfile'; then return DescriptionBytes toStringUtf8 is empty string")
  void testToProtoWithTenantProfile_thenReturnDescriptionBytesToStringUtf8IsEmptyString() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDescription(null);
    tenantProfile.setName("Tenant Profile");
    tenantProfile.setProfileDataBytes(null);

    // Act
    TransportProtos.TenantProfileProto actualToProtoResult = ProtoUtils.toProto(tenantProfile);

    // Assert
    ByteString descriptionBytes = actualToProtoResult.getDescriptionBytes();
    assertEquals("", descriptionBytes.toStringUtf8());
    assertEquals("", actualToProtoResult.getDescription());
    ByteString nameBytes = actualToProtoResult.getNameBytes();
    assertEquals("Tenant Profile", nameBytes.toStringUtf8());
    assertEquals(1, actualToProtoResult.getAllFields().size());
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    assertEquals(2, descriptorForType.getOneofs().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    assertFalse(nameBytes.isEmpty());
    assertFalse(descriptionBytes.iterator().hasNext());
    assertFalse(actualToProtoResult.hasDescription());
    assertFalse(actualToProtoResult.hasProfileData());
    assertTrue(descriptionBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals(descriptionBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(descriptionBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(descriptionBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(6).toProto();
    assertEquals(descriptionBytes, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult = fields.get(7);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals(descriptionBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(descriptionBytes, toProtoResult.getExtendeeBytes());
    assertEquals(descriptionBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(descriptionBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(descriptionBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(descriptionBytes, toProtoResult.getJsonNameBytes());
    assertEquals(descriptionBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(descriptionBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(descriptionBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(descriptionBytes, toProtoResult.getTypeNameBytes());
    assertEquals(descriptionBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(descriptionBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(descriptionBytes, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(descriptionBytes, defaultInstanceForType.getNameBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getPackageBytes());
    assertEquals(descriptionBytes, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(descriptionBytes, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(descriptionBytes, options.getCsharpNamespaceBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(descriptionBytes, options.getGoPackageBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(descriptionBytes, options.getObjcClassPrefixBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(descriptionBytes, options.getPhpClassPrefixBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(descriptionBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(descriptionBytes, options.getPhpNamespaceBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(descriptionBytes, options.getRubyPackageBytes());
    assertEquals(descriptionBytes, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(descriptionBytes, options.getSwiftPrefixBytes());
    TransportProtos.TenantProfileProto defaultInstanceForType3 = actualToProtoResult.getDefaultInstanceForType();
    assertEquals(descriptionBytes, defaultInstanceForType3.getDescriptionBytes());
    assertEquals(descriptionBytes, defaultInstanceForType3.getNameBytes());
    ByteString profileData = actualToProtoResult.getProfileData();
    assertEquals(descriptionBytes, profileData);
    assertEquals(Short.SIZE, actualToProtoResult.getSerializedSize());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('n', iteratorResult.next().byteValue());
    assertSame(profileData, getResult.getDefaultValue());
    assertSame(profileData, defaultInstanceForType3.getProfileData());
  }

  /**
   * Test {@link ProtoUtils#toProto(TenantProfile)} with {@code TenantProfile}.
   * <ul>
   *   <li>Then return ProfileData toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(TenantProfile)}
   */
  @Test
  @DisplayName("Test toProto(TenantProfile) with 'TenantProfile'; then return ProfileData toStringUtf8 is empty string")
  void testToProtoWithTenantProfile_thenReturnProfileDataToStringUtf8IsEmptyString() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDescription("Tenant Profile");
    tenantProfile.setName("Tenant Profile");
    tenantProfile.setProfileDataBytes(null);

    // Act
    TransportProtos.TenantProfileProto actualToProtoResult = ProtoUtils.toProto(tenantProfile);

    // Assert
    ByteString profileData = actualToProtoResult.getProfileData();
    assertEquals("", profileData.toStringUtf8());
    ByteString descriptionBytes = actualToProtoResult.getDescriptionBytes();
    assertEquals("Tenant Profile", descriptionBytes.toStringUtf8());
    assertEquals("Tenant Profile", actualToProtoResult.getDescription());
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    assertFalse(descriptionBytes.isEmpty());
    assertFalse(profileData.iterator().hasNext());
    assertTrue(profileData.isEmpty());
    ByteString.ByteIterator iteratorResult = descriptionBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualToProtoResult.hasDescription());
    assertEquals(descriptionBytes, actualToProtoResult.getNameBytes());
    assertEquals(profileData, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(profileData, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(profileData, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(6).toProto();
    assertEquals(profileData, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(7).toProto();
    assertEquals(profileData, toProtoResult4.getDefaultValueBytes());
    assertEquals(profileData, toProtoResult.getExtendeeBytes());
    assertEquals(profileData, toProtoResult2.getExtendeeBytes());
    assertEquals(profileData, toProtoResult3.getExtendeeBytes());
    assertEquals(profileData, toProtoResult4.getExtendeeBytes());
    assertEquals(profileData, toProtoResult.getJsonNameBytes());
    assertEquals(profileData, toProtoResult2.getJsonNameBytes());
    assertEquals(profileData, toProtoResult3.getJsonNameBytes());
    assertEquals(profileData, toProtoResult4.getJsonNameBytes());
    assertEquals(profileData, toProtoResult.getTypeNameBytes());
    assertEquals(profileData, toProtoResult2.getTypeNameBytes());
    assertEquals(profileData, toProtoResult3.getTypeNameBytes());
    assertEquals(profileData, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(profileData, defaultInstanceForType.getNameBytes());
    assertEquals(profileData, defaultInstanceForType.getPackageBytes());
    assertEquals(profileData, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(profileData, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(profileData, options.getCsharpNamespaceBytes());
    assertEquals(profileData, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(profileData, options.getGoPackageBytes());
    assertEquals(profileData, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(profileData, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(profileData, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(profileData, options.getObjcClassPrefixBytes());
    assertEquals(profileData, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(profileData, options.getPhpClassPrefixBytes());
    assertEquals(profileData, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(profileData, options.getPhpMetadataNamespaceBytes());
    assertEquals(profileData, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(profileData, options.getPhpNamespaceBytes());
    assertEquals(profileData, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(profileData, options.getRubyPackageBytes());
    assertEquals(profileData, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(profileData, options.getSwiftPrefixBytes());
    TransportProtos.TenantProfileProto defaultInstanceForType3 = actualToProtoResult.getDefaultInstanceForType();
    assertEquals(profileData, defaultInstanceForType3.getDescriptionBytes());
    assertEquals(profileData, defaultInstanceForType3.getNameBytes());
    assertEquals(Integer.SIZE, actualToProtoResult.getSerializedSize());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('n', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>Given {@code Dr}.</li>
   *   <li>When {@link Tenant#Tenant()} Title is {@code Dr}.</li>
   *   <li>Then return AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given 'Dr'; when Tenant() Title is 'Dr'; then return AllFields size is one")
  void testToProtoWithTenant_givenDr_whenTenantTitleIsDr_thenReturnAllFieldsSizeIsOne() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setTitle("Dr");

    // Act
    TransportProtos.TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals(1, actualToProtoResult.getAllFields().size());
    assertEquals(4, actualToProtoResult.getSerializedSize());
  }

  /**
   * Test {@link ProtoUtils#toProto(Tenant)} with {@code Tenant}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Tenant#Tenant()} Version is one.</li>
   *   <li>Then return Version is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(Tenant)}
   */
  @Test
  @DisplayName("Test toProto(Tenant) with 'Tenant'; given one; when Tenant() Version is one; then return Version is one")
  void testToProtoWithTenant_givenOne_whenTenantVersionIsOne_thenReturnVersionIsOne() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setVersion(1L);
    tenant.setTitle("Dr");

    // Act
    TransportProtos.TenantProto actualToProtoResult = ProtoUtils.toProto(tenant);

    // Assert
    assertEquals(1L, actualToProtoResult.getVersion());
    assertEquals(7, actualToProtoResult.getSerializedSize());
    assertTrue(actualToProtoResult.hasVersion());
  }

  /**
   * Test {@link ProtoUtils#toProto(ToDeviceActorNotificationMsg)} with
   * {@code ToDeviceActorNotificationMsg}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toProto(ToDeviceActorNotificationMsg)}
   */
  @Test
  @DisplayName("Test toProto(ToDeviceActorNotificationMsg) with 'ToDeviceActorNotificationMsg'; when 'null'; then return 'null'")
  void testToProtoWithToDeviceActorNotificationMsg_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ProtoUtils.toProto((ToDeviceActorNotificationMsg) null));
  }

  /**
   * Test {@link ProtoUtils#fromProto(AttributeValueProto)} with
   * {@code AttributeValueProto}.
   * <ul>
   *   <li>Then return {@link BaseAttributeKvEntry}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoUtils#fromProto(TransportProtos.AttributeValueProto)}
   */
  @Test
  @DisplayName("Test fromProto(AttributeValueProto) with 'AttributeValueProto'; then return BaseAttributeKvEntry")
  void testFromProtoWithAttributeValueProto_thenReturnBaseAttributeKvEntry() {
    // Arrange and Act
    AttributeKvEntry actualFromProtoResult = ProtoUtils
        .fromProto(TransportProtos.AttributeValueProto.getDefaultInstance());

    // Assert
    assertTrue(actualFromProtoResult instanceof BaseAttributeKvEntry);
    KvEntry kv = ((BaseAttributeKvEntry) actualFromProtoResult).getKv();
    assertTrue(kv instanceof BooleanDataEntry);
    assertEquals("", kv.getKey());
    assertEquals("", actualFromProtoResult.getKey());
    assertNull(actualFromProtoResult.getVersion());
    assertNull(kv.getValue());
    assertNull(actualFromProtoResult.getValue());
    assertEquals(0L, actualFromProtoResult.getLastUpdateTs());
    assertEquals(DataType.BOOLEAN, kv.getDataType());
    assertEquals(DataType.BOOLEAN, actualFromProtoResult.getDataType());
    Optional<Boolean> booleanValue = actualFromProtoResult.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertSame(booleanValue, kv.getBooleanValue());
    assertSame(booleanValue, kv.getDoubleValue());
    assertSame(booleanValue, actualFromProtoResult.getDoubleValue());
    assertSame(booleanValue, kv.getJsonValue());
    assertSame(booleanValue, actualFromProtoResult.getJsonValue());
    assertSame(booleanValue, kv.getLongValue());
    assertSame(booleanValue, actualFromProtoResult.getLongValue());
    assertSame(booleanValue, kv.getStrValue());
    assertSame(booleanValue, actualFromProtoResult.getStrValue());
  }

  /**
   * Test {@link ProtoUtils#fromProto(DeviceCredentialsProto)} with
   * {@code DeviceCredentialsProto}.
   * <ul>
   *   <li>Then return CredentialsId is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoUtils#fromProto(TransportProtos.DeviceCredentialsProto)}
   */
  @Test
  @DisplayName("Test fromProto(DeviceCredentialsProto) with 'DeviceCredentialsProto'; then return CredentialsId is empty string")
  void testFromProtoWithDeviceCredentialsProto_thenReturnCredentialsIdIsEmptyString() {
    // Arrange and Act
    DeviceCredentials actualFromProtoResult = ProtoUtils
        .fromProto(TransportProtos.DeviceCredentialsProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getCredentialsId());
    UUID uuidId = actualFromProtoResult.getUuidId();
    assertEquals("00000000-0000-0000-0000-000000000000", uuidId.toString());
    DeviceId deviceId = actualFromProtoResult.getDeviceId();
    assertEquals("00000000-0000-0000-0000-000000000000", deviceId.getId().toString());
    assertNull(actualFromProtoResult.getVersion());
    assertNull(actualFromProtoResult.getCredentialsValue());
    assertEquals(0L, actualFromProtoResult.getCreatedTime());
    assertEquals(EntityType.DEVICE, deviceId.getEntityType());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualFromProtoResult.getCredentialsType());
    assertFalse(deviceId.isNullUid());
    assertSame(uuidId, actualFromProtoResult.getId().getId());
  }

  /**
   * Test {@link ProtoUtils#fromProto(DeviceProto)} with {@code DeviceProto}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(TransportProtos.DeviceProto)}
   */
  @Test
  @DisplayName("Test fromProto(DeviceProto) with 'DeviceProto'; when DefaultInstance; then return Name is empty string")
  void testFromProtoWithDeviceProto_whenDefaultInstance_thenReturnNameIsEmptyString() {
    // Arrange and Act
    Device actualFromProtoResult = ProtoUtils.fromProto(TransportProtos.DeviceProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getName());
    assertEquals("", actualFromProtoResult.getType());
    UUID uuidId = actualFromProtoResult.getUuidId();
    assertEquals("00000000-0000-0000-0000-000000000000", uuidId.toString());
    DeviceProfileId deviceProfileId = actualFromProtoResult.getDeviceProfileId();
    assertEquals("00000000-0000-0000-0000-000000000000", deviceProfileId.getId().toString());
    TenantId tenantId = actualFromProtoResult.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertNull(actualFromProtoResult.getDeviceDataBytes());
    assertNull(actualFromProtoResult.getAdditionalInfo());
    assertNull(actualFromProtoResult.getVersion());
    assertNull(actualFromProtoResult.getLabel());
    assertNull(actualFromProtoResult.getDeviceData());
    assertNull(actualFromProtoResult.getCustomerId());
    assertNull(actualFromProtoResult.getExternalId());
    assertNull(actualFromProtoResult.getFirmwareId());
    assertNull(actualFromProtoResult.getSoftwareId());
    assertEquals(0L, actualFromProtoResult.getCreatedTime());
    DeviceId id = actualFromProtoResult.getId();
    assertEquals(EntityType.DEVICE, id.getEntityType());
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(deviceProfileId.isNullUid());
    assertFalse(id.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link ProtoUtils#fromProto(EdgeEventUpdateMsgProto)} with
   * {@code EdgeEventUpdateMsgProto}.
   * <p>
   * Method under test:
   * {@link ProtoUtils#fromProto(TransportProtos.EdgeEventUpdateMsgProto)}
   */
  @Test
  @DisplayName("Test fromProto(EdgeEventUpdateMsgProto) with 'EdgeEventUpdateMsgProto'")
  void testFromProtoWithEdgeEventUpdateMsgProto() {
    // Arrange and Act
    EdgeEventUpdateMsg actualFromProtoResult = ProtoUtils
        .fromProto(TransportProtos.EdgeEventUpdateMsgProto.getDefaultInstance());

    // Assert
    EdgeId edgeId = actualFromProtoResult.getEdgeId();
    assertEquals("00000000-0000-0000-0000-000000000000", edgeId.getId().toString());
    TenantId tenantId = actualFromProtoResult.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertEquals(EntityType.EDGE, edgeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(MsgType.EDGE_EVENT_UPDATE_TO_EDGE_SESSION_MSG, actualFromProtoResult.getMsgType());
    assertFalse(edgeId.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link ProtoUtils#fromProto(EntityTypeProto)} with
   * {@code EntityTypeProto}.
   * <ul>
   *   <li>When {@code UNSPECIFIED}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoUtils#fromProto(TransportProtos.EntityTypeProto)}
   */
  @Test
  @DisplayName("Test fromProto(EntityTypeProto) with 'EntityTypeProto'; when 'UNSPECIFIED'; then return 'null'")
  void testFromProtoWithEntityTypeProto_whenUnspecified_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ProtoUtils.fromProto(TransportProtos.EntityTypeProto.UNSPECIFIED));
  }

  /**
   * Test {@link ProtoUtils#fromProto(FromEdgeSyncResponseMsgProto)} with
   * {@code FromEdgeSyncResponseMsgProto}.
   * <ul>
   *   <li>Then return Error is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoUtils#fromProto(TransportProtos.FromEdgeSyncResponseMsgProto)}
   */
  @Test
  @DisplayName("Test fromProto(FromEdgeSyncResponseMsgProto) with 'FromEdgeSyncResponseMsgProto'; then return Error is empty string")
  void testFromProtoWithFromEdgeSyncResponseMsgProto_thenReturnErrorIsEmptyString() {
    // Arrange and Act
    FromEdgeSyncResponse actualFromProtoResult = ProtoUtils
        .fromProto(TransportProtos.FromEdgeSyncResponseMsgProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getError());
    EdgeId edgeId = actualFromProtoResult.getEdgeId();
    assertEquals("00000000-0000-0000-0000-000000000000", edgeId.getId().toString());
    TenantId tenantId = actualFromProtoResult.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertEquals("00000000-0000-0000-0000-000000000000", actualFromProtoResult.getId().toString());
    assertEquals(EntityType.EDGE, edgeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(MsgType.EDGE_SYNC_RESPONSE_FROM_EDGE_SESSION_MSG, actualFromProtoResult.getMsgType());
    assertFalse(edgeId.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertFalse(actualFromProtoResult.isSuccess());
  }

  /**
   * Test {@link ProtoUtils#fromProto(TenantProfileProto)} with
   * {@code TenantProfileProto}.
   * <ul>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoUtils#fromProto(TransportProtos.TenantProfileProto)}
   */
  @Test
  @DisplayName("Test fromProto(TenantProfileProto) with 'TenantProfileProto'; then return Name is empty string")
  void testFromProtoWithTenantProfileProto_thenReturnNameIsEmptyString() {
    // Arrange and Act
    TenantProfile actualFromProtoResult = ProtoUtils.fromProto(TransportProtos.TenantProfileProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getName());
    UUID uuidId = actualFromProtoResult.getUuidId();
    assertEquals("00000000-0000-0000-0000-000000000000", uuidId.toString());
    assertNull(actualFromProtoResult.getProfileDataBytes());
    DefaultTenantProfileConfiguration defaultProfileConfiguration = actualFromProtoResult
        .getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(actualFromProtoResult.getDescription());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = actualFromProtoResult.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualFromProtoResult.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    TenantProfileId id = actualFromProtoResult.getId();
    assertEquals(EntityType.TENANT_PROFILE, id.getEntityType());
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    assertFalse(actualFromProtoResult.isDefault());
    assertFalse(actualFromProtoResult.isIsolatedTbRuleEngine());
    assertFalse(id.isNullUid());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = actualFromProtoResult.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link ProtoUtils#fromProto(TenantProto)} with {@code TenantProto}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#fromProto(TransportProtos.TenantProto)}
   */
  @Test
  @DisplayName("Test fromProto(TenantProto) with 'TenantProto'; when DefaultInstance; then return Name is empty string")
  void testFromProtoWithTenantProto_whenDefaultInstance_thenReturnNameIsEmptyString() {
    // Arrange and Act
    Tenant actualFromProtoResult = ProtoUtils.fromProto(TransportProtos.TenantProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getName());
    assertEquals("", actualFromProtoResult.getTitle());
    UUID uuidId = actualFromProtoResult.getUuidId();
    assertEquals("00000000-0000-0000-0000-000000000000", uuidId.toString());
    TenantProfileId tenantProfileId = actualFromProtoResult.getTenantProfileId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantProfileId.getId().toString());
    assertNull(actualFromProtoResult.getAdditionalInfo());
    assertNull(actualFromProtoResult.getVersion());
    assertNull(actualFromProtoResult.getAddress());
    assertNull(actualFromProtoResult.getAddress2());
    assertNull(actualFromProtoResult.getCity());
    assertNull(actualFromProtoResult.getCountry());
    assertNull(actualFromProtoResult.getEmail());
    assertNull(actualFromProtoResult.getPhone());
    assertNull(actualFromProtoResult.getRegion());
    assertNull(actualFromProtoResult.getState());
    assertNull(actualFromProtoResult.getZip());
    assertEquals(0L, actualFromProtoResult.getCreatedTime());
    TenantId id = actualFromProtoResult.getId();
    assertEquals(EntityType.TENANT, id.getEntityType());
    assertEquals(EntityType.TENANT_PROFILE, tenantProfileId.getEntityType());
    assertFalse(id.isNullUid());
    assertFalse(tenantProfileId.isNullUid());
    assertFalse(id.isSysTenantId());
    assertSame(id, actualFromProtoResult.getTenantId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link ProtoUtils#fromProto(ToDeviceActorNotificationMsgProto)} with
   * {@code ToDeviceActorNotificationMsgProto}.
   * <p>
   * Method under test:
   * {@link ProtoUtils#fromProto(TransportProtos.ToDeviceActorNotificationMsgProto)}
   */
  @Test
  @DisplayName("Test fromProto(ToDeviceActorNotificationMsgProto) with 'ToDeviceActorNotificationMsgProto'")
  void testFromProtoWithToDeviceActorNotificationMsgProto() {
    // Arrange, Act and Assert
    assertNull(ProtoUtils.fromProto(TransportProtos.ToDeviceActorNotificationMsgProto.getDefaultInstance()));
  }

  /**
   * Test {@link ProtoUtils#fromProto(ToEdgeSyncRequestMsgProto)} with
   * {@code ToEdgeSyncRequestMsgProto}.
   * <ul>
   *   <li>Then return ServiceId is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoUtils#fromProto(TransportProtos.ToEdgeSyncRequestMsgProto)}
   */
  @Test
  @DisplayName("Test fromProto(ToEdgeSyncRequestMsgProto) with 'ToEdgeSyncRequestMsgProto'; then return ServiceId is empty string")
  void testFromProtoWithToEdgeSyncRequestMsgProto_thenReturnServiceIdIsEmptyString() {
    // Arrange and Act
    ToEdgeSyncRequest actualFromProtoResult = ProtoUtils
        .fromProto(TransportProtos.ToEdgeSyncRequestMsgProto.getDefaultInstance());

    // Assert
    assertEquals("", actualFromProtoResult.getServiceId());
    EdgeId edgeId = actualFromProtoResult.getEdgeId();
    assertEquals("00000000-0000-0000-0000-000000000000", edgeId.getId().toString());
    TenantId tenantId = actualFromProtoResult.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertEquals("00000000-0000-0000-0000-000000000000", actualFromProtoResult.getId().toString());
    assertEquals(EntityType.EDGE, edgeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(MsgType.EDGE_SYNC_REQUEST_TO_EDGE_SESSION_MSG, actualFromProtoResult.getMsgType());
    assertFalse(edgeId.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link ProtoUtils#toEntityUpdateProto(Object)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link OAuth2Client#OAuth2Client()} AdditionalInfo is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toEntityUpdateProto(Object)}
   */
  @Test
  @DisplayName("Test toEntityUpdateProto(Object); given 'null'; when OAuth2Client() AdditionalInfo is 'null'")
  void testToEntityUpdateProto_givenNull_whenOAuth2ClientAdditionalInfoIsNull() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setAdditionalInfo(null);

    // Act
    TransportProtos.EntityUpdateMsg actualToEntityUpdateProtoResult = ProtoUtils.toEntityUpdateProto(oAuth2Client);

    // Assert
    Descriptors.Descriptor descriptorForType = actualToEntityUpdateProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    List<Descriptors.OneofDescriptor> realOneofs = descriptorForType.getRealOneofs();
    assertEquals(1, realOneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(5, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    Descriptors.OneofDescriptor getResult = oneofs.get(0);
    assertEquals(fields, getResult.getFields());
    assertEquals(actualToEntityUpdateProtoResult, actualToEntityUpdateProtoResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    TransportProtos.ApiUsageStateProto apiUsageState = actualToEntityUpdateProtoResult.getApiUsageState();
    Descriptors.Descriptor descriptorForType2 = apiUsageState.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    TransportProtos.DeviceProto device = actualToEntityUpdateProtoResult.getDevice();
    Descriptors.Descriptor descriptorForType3 = device.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    assertSame(reservedNameList, toProtoResult4.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceProfileProto deviceProfile = actualToEntityUpdateProtoResult.getDeviceProfile();
    Descriptors.Descriptor descriptorForType4 = deviceProfile.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.TenantProto tenant = actualToEntityUpdateProtoResult.getTenant();
    Descriptors.Descriptor descriptorForType5 = tenant.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.TenantProfileProto tenantProfile = actualToEntityUpdateProtoResult.getTenantProfile();
    Descriptors.Descriptor descriptorForType6 = tenantProfile.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(4);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult5.getMessageType());
    assertSame(descriptorForType4, getResult4.getMessageType());
    assertSame(descriptorForType5, getResult2.getMessageType());
    assertSame(descriptorForType6, getResult3.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    UnknownFieldSet unknownFields = actualToEntityUpdateProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, apiUsageState.getUnknownFields());
    assertSame(unknownFields, device.getUnknownFields());
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    assertSame(unknownFields, tenant.getUnknownFields());
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult, getResult2.getContainingOneof());
    assertSame(getResult, getResult3.getContainingOneof());
    assertSame(getResult, getResult4.getContainingOneof());
    assertSame(getResult, getResult5.getContainingOneof());
    assertSame(getResult, getResult2.getRealContainingOneof());
    assertSame(getResult, getResult3.getRealContainingOneof());
    assertSame(getResult, getResult4.getRealContainingOneof());
    assertSame(getResult, getResult5.getRealContainingOneof());
    assertSame(getResult, realOneofs.get(0));
    ByteString deviceData = device.getDeviceData();
    assertSame(deviceData, deviceProfile.getDeviceProfileData());
    assertSame(deviceData, tenantProfile.getProfileData());
    assertSame(apiUsageState, apiUsageState.getDefaultInstanceForType());
    assertSame(apiUsageState, actualToEntityUpdateProtoResult.getApiUsageStateOrBuilder());
    assertSame(device, device.getDefaultInstanceForType());
    assertSame(device, actualToEntityUpdateProtoResult.getDeviceOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, actualToEntityUpdateProtoResult.getDeviceProfileOrBuilder());
    assertSame(tenant, actualToEntityUpdateProtoResult.getTenantOrBuilder());
    assertSame(tenant, tenant.getDefaultInstanceForType());
    assertSame(tenantProfile, actualToEntityUpdateProtoResult.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toEntityUpdateProto(Object)}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toEntityUpdateProto(Object)}
   */
  @Test
  @DisplayName("Test toEntityUpdateProto(Object); when 'Entity'")
  void testToEntityUpdateProto_whenEntity() {
    // Arrange and Act
    TransportProtos.EntityUpdateMsg actualToEntityUpdateProtoResult = ProtoUtils.toEntityUpdateProto("Entity");

    // Assert
    Descriptors.Descriptor descriptorForType = actualToEntityUpdateProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    List<Descriptors.OneofDescriptor> realOneofs = descriptorForType.getRealOneofs();
    assertEquals(1, realOneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(5, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    Descriptors.OneofDescriptor getResult = oneofs.get(0);
    assertEquals(fields, getResult.getFields());
    assertEquals(actualToEntityUpdateProtoResult, actualToEntityUpdateProtoResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    TransportProtos.ApiUsageStateProto apiUsageState = actualToEntityUpdateProtoResult.getApiUsageState();
    Descriptors.Descriptor descriptorForType2 = apiUsageState.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    TransportProtos.DeviceProto device = actualToEntityUpdateProtoResult.getDevice();
    Descriptors.Descriptor descriptorForType3 = device.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    assertSame(reservedNameList, toProtoResult4.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    TransportProtos.DeviceProfileProto deviceProfile = actualToEntityUpdateProtoResult.getDeviceProfile();
    Descriptors.Descriptor descriptorForType4 = deviceProfile.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    TransportProtos.TenantProto tenant = actualToEntityUpdateProtoResult.getTenant();
    Descriptors.Descriptor descriptorForType5 = tenant.getDescriptorForType();
    assertSame(file, descriptorForType5.getFile());
    TransportProtos.TenantProfileProto tenantProfile = actualToEntityUpdateProtoResult.getTenantProfile();
    Descriptors.Descriptor descriptorForType6 = tenantProfile.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(4);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult5.getMessageType());
    assertSame(descriptorForType4, getResult4.getMessageType());
    assertSame(descriptorForType5, getResult2.getMessageType());
    assertSame(descriptorForType6, getResult3.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    UnknownFieldSet unknownFields = actualToEntityUpdateProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, apiUsageState.getUnknownFields());
    assertSame(unknownFields, device.getUnknownFields());
    assertSame(unknownFields, deviceProfile.getUnknownFields());
    assertSame(unknownFields, tenant.getUnknownFields());
    assertSame(unknownFields, tenantProfile.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult, getResult2.getContainingOneof());
    assertSame(getResult, getResult3.getContainingOneof());
    assertSame(getResult, getResult4.getContainingOneof());
    assertSame(getResult, getResult5.getContainingOneof());
    assertSame(getResult, getResult2.getRealContainingOneof());
    assertSame(getResult, getResult3.getRealContainingOneof());
    assertSame(getResult, getResult4.getRealContainingOneof());
    assertSame(getResult, getResult5.getRealContainingOneof());
    assertSame(getResult, realOneofs.get(0));
    ByteString deviceData = device.getDeviceData();
    assertSame(deviceData, deviceProfile.getDeviceProfileData());
    assertSame(deviceData, tenantProfile.getProfileData());
    assertSame(apiUsageState, apiUsageState.getDefaultInstanceForType());
    assertSame(apiUsageState, actualToEntityUpdateProtoResult.getApiUsageStateOrBuilder());
    assertSame(device, device.getDefaultInstanceForType());
    assertSame(device, actualToEntityUpdateProtoResult.getDeviceOrBuilder());
    assertSame(deviceProfile, deviceProfile.getDefaultInstanceForType());
    assertSame(deviceProfile, actualToEntityUpdateProtoResult.getDeviceProfileOrBuilder());
    assertSame(tenant, actualToEntityUpdateProtoResult.getTenantOrBuilder());
    assertSame(tenant, tenant.getDefaultInstanceForType());
    assertSame(tenantProfile, actualToEntityUpdateProtoResult.getTenantProfileOrBuilder());
    assertSame(tenantProfile, tenantProfile.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoUtils#toDeviceInfoProto(Device)}.
   * <p>
   * Method under test: {@link ProtoUtils#toDeviceInfoProto(Device)}
   */
  @Test
  @DisplayName("Test toDeviceInfoProto(Device)")
  void testToDeviceInfoProto() throws JsonProcessingException {
    // Arrange
    DeviceTransportConfiguration transportConfiguration = mock(DeviceTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceTransportConfiguration deviceTransportConfiguration = mock(DeviceTransportConfiguration.class);
    when(deviceTransportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceData deviceData = mock(DeviceData.class);
    when(deviceData.getTransportConfiguration()).thenReturn(deviceTransportConfiguration);
    doNothing().when(deviceData).setConfiguration(Mockito.<DeviceConfiguration>any());
    doNothing().when(deviceData).setTransportConfiguration(Mockito.<DeviceTransportConfiguration>any());
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(transportConfiguration);
    Device device = mock(Device.class);
    when(device.getDeviceData()).thenReturn(deviceData);
    when(device.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true), 3));
    when(device.getDeviceProfileId()).thenReturn(new DeviceProfileId(UUID.randomUUID()));
    when(device.getType()).thenReturn("Type");
    when(device.getName()).thenReturn("Name");
    when(device.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(device.getId()).thenReturn(new DeviceId(UUID.randomUUID()));
    when(device.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(device).setTenantId(Mockito.<TenantId>any());
    device.setTenantId(new TenantId(null));

    // Act
    ProtoUtils.toDeviceInfoProto(device);

    // Assert
    verify(device, atLeast(1)).getAdditionalInfo();
    verify(device, atLeast(1)).getCustomerId();
    verify(device).getDeviceData();
    verify(device, atLeast(1)).getDeviceProfileId();
    verify(device, atLeast(1)).getId();
    verify(device).getName();
    verify(device, atLeast(1)).getTenantId();
    verify(device).getType();
    verify(device).setTenantId(isA(TenantId.class));
    verify(deviceData).getTransportConfiguration();
    verify(deviceData).setConfiguration(isA(DeviceConfiguration.class));
    verify(deviceData).setTransportConfiguration(isA(DeviceTransportConfiguration.class));
    verify(deviceTransportConfiguration).getType();
  }

  /**
   * Test {@link ProtoUtils#toDeviceInfoProto(Device)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toDeviceInfoProto(Device)}
   */
  @Test
  @DisplayName("Test toDeviceInfoProto(Device); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  void testToDeviceInfoProto_givenArrayNodeWithNfIsWithExactBigDecimalsTrue() throws JsonProcessingException {
    // Arrange
    DeviceTransportConfiguration transportConfiguration = mock(DeviceTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceTransportConfiguration deviceTransportConfiguration = mock(DeviceTransportConfiguration.class);
    when(deviceTransportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceData deviceData = mock(DeviceData.class);
    when(deviceData.getTransportConfiguration()).thenReturn(deviceTransportConfiguration);
    doNothing().when(deviceData).setConfiguration(Mockito.<DeviceConfiguration>any());
    doNothing().when(deviceData).setTransportConfiguration(Mockito.<DeviceTransportConfiguration>any());
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(transportConfiguration);
    Device device = mock(Device.class);
    when(device.getDeviceData()).thenReturn(deviceData);
    when(device.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(device.getDeviceProfileId()).thenReturn(new DeviceProfileId(UUID.randomUUID()));
    when(device.getType()).thenReturn("Type");
    when(device.getName()).thenReturn("Name");
    when(device.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(device.getId()).thenReturn(new DeviceId(UUID.randomUUID()));
    when(device.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(device).setTenantId(Mockito.<TenantId>any());
    device.setTenantId(new TenantId(null));

    // Act
    ProtoUtils.toDeviceInfoProto(device);

    // Assert
    verify(device, atLeast(1)).getAdditionalInfo();
    verify(device, atLeast(1)).getCustomerId();
    verify(device).getDeviceData();
    verify(device, atLeast(1)).getDeviceProfileId();
    verify(device, atLeast(1)).getId();
    verify(device).getName();
    verify(device, atLeast(1)).getTenantId();
    verify(device).getType();
    verify(device).setTenantId(isA(TenantId.class));
    verify(deviceData).getTransportConfiguration();
    verify(deviceData).setConfiguration(isA(DeviceConfiguration.class));
    verify(deviceData).setTransportConfiguration(isA(DeviceTransportConfiguration.class));
    verify(deviceTransportConfiguration).getType();
  }

  /**
   * Test {@link ProtoUtils#toDeviceInfoProto(Device)}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#get(String)} return False.</li>
   *   <li>Then calls {@link JsonNode#get(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toDeviceInfoProto(Device)}
   */
  @Test
  @DisplayName("Test toDeviceInfoProto(Device); given JsonNode get(String) return False; then calls get(String)")
  void testToDeviceInfoProto_givenJsonNodeGetReturnFalse_thenCallsGet() throws IOException {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.get(Mockito.<String>any())).thenReturn(BooleanNode.getFalse());
    doNothing().when(jsonNode).serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    when(jsonNode.has(Mockito.<String>any())).thenReturn(true);
    DeviceTransportConfiguration transportConfiguration = mock(DeviceTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceTransportConfiguration deviceTransportConfiguration = mock(DeviceTransportConfiguration.class);
    when(deviceTransportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceData deviceData = mock(DeviceData.class);
    when(deviceData.getTransportConfiguration()).thenReturn(deviceTransportConfiguration);
    doNothing().when(deviceData).setConfiguration(Mockito.<DeviceConfiguration>any());
    doNothing().when(deviceData).setTransportConfiguration(Mockito.<DeviceTransportConfiguration>any());
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(transportConfiguration);
    Device device = mock(Device.class);
    when(device.getDeviceData()).thenReturn(deviceData);
    when(device.getAdditionalInfo()).thenReturn(jsonNode);
    when(device.getDeviceProfileId()).thenReturn(new DeviceProfileId(UUID.randomUUID()));
    when(device.getType()).thenReturn("Type");
    when(device.getName()).thenReturn("Name");
    when(device.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(device.getId()).thenReturn(new DeviceId(UUID.randomUUID()));
    when(device.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(device).setTenantId(Mockito.<TenantId>any());
    device.setTenantId(new TenantId(null));

    // Act
    ProtoUtils.toDeviceInfoProto(device);

    // Assert
    verify(jsonNode).get(eq("gateway"));
    verify(jsonNode).has(eq("gateway"));
    verify(jsonNode).serialize(isA(JsonGenerator.class), isA(SerializerProvider.class));
    verify(device, atLeast(1)).getAdditionalInfo();
    verify(device, atLeast(1)).getCustomerId();
    verify(device).getDeviceData();
    verify(device, atLeast(1)).getDeviceProfileId();
    verify(device, atLeast(1)).getId();
    verify(device).getName();
    verify(device, atLeast(1)).getTenantId();
    verify(device).getType();
    verify(device).setTenantId(isA(TenantId.class));
    verify(deviceData).getTransportConfiguration();
    verify(deviceData).setConfiguration(isA(DeviceConfiguration.class));
    verify(deviceData).setTransportConfiguration(isA(DeviceTransportConfiguration.class));
    verify(deviceTransportConfiguration).getType();
  }

  /**
   * Test {@link ProtoUtils#toDeviceInfoProto(Device)}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#get(String)} return Instance.</li>
   *   <li>Then calls {@link JsonNode#get(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoUtils#toDeviceInfoProto(Device)}
   */
  @Test
  @DisplayName("Test toDeviceInfoProto(Device); given JsonNode get(String) return Instance; then calls get(String)")
  void testToDeviceInfoProto_givenJsonNodeGetReturnInstance_thenCallsGet() throws IOException {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    doNothing().when(jsonNode).serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    when(jsonNode.has(Mockito.<String>any())).thenReturn(true);
    DeviceTransportConfiguration transportConfiguration = mock(DeviceTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceTransportConfiguration deviceTransportConfiguration = mock(DeviceTransportConfiguration.class);
    when(deviceTransportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceData deviceData = mock(DeviceData.class);
    when(deviceData.getTransportConfiguration()).thenReturn(deviceTransportConfiguration);
    doNothing().when(deviceData).setConfiguration(Mockito.<DeviceConfiguration>any());
    doNothing().when(deviceData).setTransportConfiguration(Mockito.<DeviceTransportConfiguration>any());
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(transportConfiguration);
    Device device = mock(Device.class);
    when(device.getDeviceData()).thenReturn(deviceData);
    when(device.getAdditionalInfo()).thenReturn(jsonNode);
    when(device.getDeviceProfileId()).thenReturn(new DeviceProfileId(UUID.randomUUID()));
    when(device.getType()).thenReturn("Type");
    when(device.getName()).thenReturn("Name");
    when(device.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(device.getId()).thenReturn(new DeviceId(UUID.randomUUID()));
    when(device.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(device).setTenantId(Mockito.<TenantId>any());
    device.setTenantId(new TenantId(null));

    // Act
    ProtoUtils.toDeviceInfoProto(device);

    // Assert
    verify(jsonNode).get(eq("gateway"));
    verify(jsonNode).has(eq("gateway"));
    verify(jsonNode).serialize(isA(JsonGenerator.class), isA(SerializerProvider.class));
    verify(device, atLeast(1)).getAdditionalInfo();
    verify(device, atLeast(1)).getCustomerId();
    verify(device).getDeviceData();
    verify(device, atLeast(1)).getDeviceProfileId();
    verify(device, atLeast(1)).getId();
    verify(device).getName();
    verify(device, atLeast(1)).getTenantId();
    verify(device).getType();
    verify(device).setTenantId(isA(TenantId.class));
    verify(deviceData).getTransportConfiguration();
    verify(deviceData).setConfiguration(isA(DeviceConfiguration.class));
    verify(deviceData).setTransportConfiguration(isA(DeviceTransportConfiguration.class));
    verify(deviceTransportConfiguration).getType();
  }
}
