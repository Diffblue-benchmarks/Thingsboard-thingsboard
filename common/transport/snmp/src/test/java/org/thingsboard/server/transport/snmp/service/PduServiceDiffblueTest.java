package org.thingsboard.server.transport.snmp.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.snmp4j.PDU;
import org.snmp4j.ScopedPDU;
import org.snmp4j.agent.mo.snmp.RowCount;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.transport.snmp.SnmpMapping;
import org.thingsboard.server.common.data.transport.snmp.SnmpMethod;
import org.thingsboard.server.common.data.transport.snmp.SnmpProtocolVersion;
import org.thingsboard.server.transport.snmp.session.DeviceSessionContext;

class PduServiceDiffblueTest {
  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setContextName("42");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);
    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act
    PDU actualCreateSingleVariablePduResult =
        pduService.createSingleVariablePdu(
            sessionContext, SnmpMethod.GET, "42", "42", DataType.BOOLEAN);

    // Assert
    verify(sessionContext).getDeviceTransportConfiguration();
    assertTrue(actualCreateSingleVariablePduResult instanceof ScopedPDU);
    List<VariableBinding> all = actualCreateSingleVariablePduResult.getAll();
    assertEquals(1, all.size());
    VariableBinding getResult = all.get(0);
    Variable variable = getResult.getVariable();
    assertTrue(variable instanceof OctetString);
    OctetString contextEngineID =
        ((ScopedPDU) actualCreateSingleVariablePduResult).getContextEngineID();
    assertEquals(
        contextEngineID, ((ScopedPDU) actualCreateSingleVariablePduResult).getContextName());
    byte[] value = contextEngineID.getValue();
    assertSame(value, contextEngineID.toByteArray());
    OID oid = getResult.getOid();
    assertArrayEquals(new byte[] {'*'}, oid.toByteArray());
    assertArrayEquals(new byte[] {'4', '2'}, value);
    assertArrayEquals(new byte[] {'4', '2'}, ((OctetString) variable).getValue());
    assertArrayEquals(new int[] {42}, oid.getValue());
    assertArrayEquals(new long[] {42L}, oid.toUnsignedLongArray());
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>Then return BERPayloadLength is twenty.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); then return BERPayloadLength is twenty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_thenReturnBERPayloadLengthIsTwenty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V1);
    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act
    PDU actualCreateSingleVariablePduResult =
        pduService.createSingleVariablePdu(
            sessionContext, SnmpMethod.GET, "42", "42", DataType.BOOLEAN);

    // Assert
    verify(sessionContext).getDeviceTransportConfiguration();
    List<VariableBinding> all = actualCreateSingleVariablePduResult.getAll();
    assertEquals(1, all.size());
    VariableBinding getResult = all.get(0);
    Variable variable = getResult.getVariable();
    assertTrue(variable instanceof OctetString);
    assertEquals(20, actualCreateSingleVariablePduResult.getBERPayloadLength());
    assertEquals(22, actualCreateSingleVariablePduResult.getBERLength());
    OID oid = getResult.getOid();
    OID trimResult = oid.trim();
    assertArrayEquals(new byte[] {}, trimResult.toByteArray());
    assertArrayEquals(new byte[] {'*'}, oid.toByteArray());
    OID successorResult = oid.successor();
    assertArrayEquals(new byte[] {'*', 0}, successorResult.toByteArray());
    assertArrayEquals(new byte[] {'4', '2'}, ((OctetString) variable).getValue());
    assertArrayEquals(new int[] {}, trimResult.getValue());
    assertArrayEquals(new int[] {42}, oid.getValue());
    assertArrayEquals(new int[] {42, 0}, successorResult.getValue());
    assertArrayEquals(new long[] {}, trimResult.toUnsignedLongArray());
    assertArrayEquals(new long[] {42L}, oid.toUnsignedLongArray());
    assertArrayEquals(new long[] {42L, 0L}, successorResult.toUnsignedLongArray());
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();
    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenThrow(new NumberFormatException("foo"));

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            pduService.createSingleVariablePdu(
                sessionContext, SnmpMethod.GET, "Oid", "42", DataType.BOOLEAN));
    verify(sessionContext).getDeviceTransportConfiguration();
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>When {@code LONG}.
   *   <li>Then return BERPayloadLength is twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); when 'LONG'; then return BERPayloadLength is twenty-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_whenLong_thenReturnBERPayloadLengthIsTwentyNine() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setContextName("42");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);
    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act
    PDU actualCreateSingleVariablePduResult =
        pduService.createSingleVariablePdu(
            sessionContext, SnmpMethod.GET, "42", "42", DataType.LONG);

    // Assert
    verify(sessionContext).getDeviceTransportConfiguration();
    assertTrue(actualCreateSingleVariablePduResult instanceof ScopedPDU);
    assertEquals(1, actualCreateSingleVariablePduResult.toArray().length);
    assertEquals(29, actualCreateSingleVariablePduResult.getBERPayloadLength());
    assertEquals(31, actualCreateSingleVariablePduResult.getBERLength());
    OctetString contextEngineID =
        ((ScopedPDU) actualCreateSingleVariablePduResult).getContextEngineID();
    assertEquals(
        contextEngineID, ((ScopedPDU) actualCreateSingleVariablePduResult).getContextName());
    byte[] value = contextEngineID.getValue();
    assertSame(value, contextEngineID.toByteArray());
    assertArrayEquals(new byte[] {'4', '2'}, value);
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return All first Variable is ContextEngineID.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); when 'null'; then return All first Variable is ContextEngineID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_whenNull_thenReturnAllFirstVariableIsContextEngineID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setContextName("42");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);
    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act
    PDU actualCreateSingleVariablePduResult =
        pduService.createSingleVariablePdu(sessionContext, SnmpMethod.GET, "42", "42", null);

    // Assert
    verify(sessionContext).getDeviceTransportConfiguration();
    assertTrue(actualCreateSingleVariablePduResult instanceof ScopedPDU);
    List<VariableBinding> all = actualCreateSingleVariablePduResult.getAll();
    assertEquals(1, all.size());
    VariableBinding getResult = all.get(0);
    Variable variable = getResult.getVariable();
    assertTrue(variable instanceof OctetString);
    VariableBinding[] toArrayResult = actualCreateSingleVariablePduResult.toArray();
    assertEquals(1, toArrayResult.length);
    OctetString contextEngineID =
        ((ScopedPDU) actualCreateSingleVariablePduResult).getContextEngineID();
    assertEquals(
        contextEngineID, ((ScopedPDU) actualCreateSingleVariablePduResult).getContextName());
    assertEquals(contextEngineID, variable);
    assertSame(getResult, toArrayResult[0]);
    assertSame(all, actualCreateSingleVariablePduResult.getVariableBindings());
    byte[] value = contextEngineID.getValue();
    assertSame(value, contextEngineID.toByteArray());
    assertArrayEquals(new byte[] {'4', '2'}, value);
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return BERPayloadLength is twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); when 'null'; then return BERPayloadLength is twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_whenNull_thenReturnBERPayloadLengthIsTwentyEight() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setContextName("42");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);
    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act
    PDU actualCreateSingleVariablePduResult =
        pduService.createSingleVariablePdu(
            sessionContext, SnmpMethod.GET, "42", null, DataType.BOOLEAN);

    // Assert
    verify(sessionContext).getDeviceTransportConfiguration();
    assertTrue(actualCreateSingleVariablePduResult instanceof ScopedPDU);
    assertEquals(1, actualCreateSingleVariablePduResult.toArray().length);
    assertEquals(28, actualCreateSingleVariablePduResult.getBERPayloadLength());
    assertEquals(30, actualCreateSingleVariablePduResult.getBERLength());
    OctetString contextEngineID =
        ((ScopedPDU) actualCreateSingleVariablePduResult).getContextEngineID();
    assertEquals(
        contextEngineID, ((ScopedPDU) actualCreateSingleVariablePduResult).getContextName());
    byte[] value = contextEngineID.getValue();
    assertSame(value, contextEngineID.toByteArray());
    assertArrayEquals(new byte[] {'4', '2'}, value);
  }

  /**
   * Test {@link PduService#createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String,
   * String, DataType)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return BERPayloadLength is thirty-three.
   * </ul>
   *
   * <p>Method under test: {@link PduService#createSingleVariablePdu(DeviceSessionContext,
   * SnmpMethod, String, String, DataType)}
   */
  @Test
  @DisplayName(
      "Test createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType); when 'Value'; then return BERPayloadLength is thirty-three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "PDU PduService.createSingleVariablePdu(DeviceSessionContext, SnmpMethod, String, String, DataType)"
  })
  void testCreateSingleVariablePdu_whenValue_thenReturnBERPayloadLengthIsThirtyThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PduService pduService = new PduService();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration =
        new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setContextName("42");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);
    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(snmpDeviceTransportConfiguration);

    // Act
    PDU actualCreateSingleVariablePduResult =
        pduService.createSingleVariablePdu(
            sessionContext, SnmpMethod.GET, "42", "Value", DataType.LONG);

    // Assert
    verify(sessionContext).getDeviceTransportConfiguration();
    assertTrue(actualCreateSingleVariablePduResult instanceof ScopedPDU);
    assertEquals(1, actualCreateSingleVariablePduResult.toArray().length);
    assertEquals(33, actualCreateSingleVariablePduResult.getBERPayloadLength());
    assertEquals(35, actualCreateSingleVariablePduResult.getBERLength());
    OctetString contextEngineID =
        ((ScopedPDU) actualCreateSingleVariablePduResult).getContextEngineID();
    assertEquals(
        contextEngineID, ((ScopedPDU) actualCreateSingleVariablePduResult).getContextName());
    byte[] value = contextEngineID.getValue();
    assertSame(value, contextEngineID.toByteArray());
    assertArrayEquals(new byte[] {'4', '2'}, value);
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName("Test processPdus(List, List) with 'pdus', 'responseMappings'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings() {
    // Arrange
    PduService pduService = new PduService();
    ArrayList<PDU> pdus = new ArrayList<>();

    ArrayList<SnmpMapping> responseMappings = new ArrayList<>();
    responseMappings.add(new SnmpMapping("42", "Key", DataType.BOOLEAN));

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, responseMappings);

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()} add {@link VariableBinding#VariableBinding()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; given PDU() add VariableBinding()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_givenPduAddVariableBinding() {
    // Arrange
    PduService pduService = new PduService();

    PDU pdu = new PDU();
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; given PDU(); when ArrayList() add PDU()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_givenPdu_whenArrayListAddPdu() {
    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; given PDU(); when ArrayList() add PDU()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_givenPdu_whenArrayListAddPdu2() {
    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());
    pdus.add(new PDU());

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>Then calls {@link PDU#add(VariableBinding)}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; then calls add(VariableBinding)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_thenCallsAdd() {
    // Arrange
    PduService pduService = new PduService();
    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings())
        .thenReturn(new ArrayList<>());
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>Then calls {@link VariableBinding#getOid()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName("Test processPdus(List, List) with 'pdus', 'responseMappings'; then calls getOid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_thenCallsGetOid() {
    // Arrange
    PduService pduService = new PduService();
    VariableBinding variableBinding = mock(VariableBinding.class);
    when(variableBinding.toValueString()).thenReturn("42");
    when(variableBinding.getOid()).thenReturn(new OID());
    when(variableBinding.getVariable()).thenReturn(new RowCount());

    ArrayList<VariableBinding> variableBindingList = new ArrayList<>();
    variableBindingList.add(variableBinding);
    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings())
        .thenReturn(variableBindingList);
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    verify(variableBinding).getOid();
    verify(variableBinding).getVariable();
    verify(variableBinding).toValueString();
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; when ArrayList(); then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_whenArrayList_thenReturnSizeIsZero() {
    // Arrange
    PduService pduService = new PduService();
    ArrayList<PDU> pdus = new ArrayList<>();

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(pdus, new ArrayList<>());

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Test {@link PduService#processPdus(List, List)} with {@code pdus}, {@code responseMappings}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List, List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List, List) with 'pdus', 'responseMappings'; when 'null'; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonObject PduService.processPdus(List, List)"})
  void testProcessPdusWithPdusResponseMappings_whenNull_thenReturnSizeIsZero() {
    // Arrange
    PduService pduService = new PduService();

    // Act
    JsonObject actualProcessPdusResult = pduService.processPdus(new ArrayList<>(), null);

    // Assert
    assertEquals(0, actualProcessPdusResult.size());
    assertFalse(actualProcessPdusResult.isJsonArray());
    assertFalse(actualProcessPdusResult.isJsonNull());
    assertFalse(actualProcessPdusResult.isJsonPrimitive());
    assertTrue(actualProcessPdusResult.isJsonObject());
    assertTrue(actualProcessPdusResult.isEmpty());
    assertSame(actualProcessPdusResult, actualProcessPdusResult.getAsJsonObject());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()} add {@link VariableBinding#VariableBinding()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List) with 'pdus'; given PDU() add VariableBinding(); when ArrayList() add PDU()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_givenPduAddVariableBinding_whenArrayListAddPdu() {
    // Arrange
    PduService pduService = new PduService();

    PDU pdu = new PDU();
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act and Assert
    assertTrue(pduService.processPdus(pdus).isEmpty());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>Given {@link PDU} {@link PDU#getVariableBindings()} return {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link PDU#add(VariableBinding)}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List) with 'pdus'; given PDU getVariableBindings() return ArrayList(); then calls add(VariableBinding)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_givenPduGetVariableBindingsReturnArrayList_thenCallsAdd() {
    // Arrange
    PduService pduService = new PduService();
    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings())
        .thenReturn(new ArrayList<>());
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    Map<OID, String> actualProcessPdusResult = pduService.processPdus(pdus);

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    assertTrue(actualProcessPdusResult.isEmpty());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List) with 'pdus'; given PDU(); when ArrayList() add PDU(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_givenPdu_whenArrayListAddPdu_thenReturnEmpty() {
    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());

    // Act and Assert
    assertTrue(pduService.processPdus(pdus).isEmpty());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>Given {@link PDU#PDU()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDU#PDU()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName(
      "Test processPdus(List) with 'pdus'; given PDU(); when ArrayList() add PDU(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_givenPdu_whenArrayListAddPdu_thenReturnEmpty2() {
    // Arrange
    PduService pduService = new PduService();

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(new PDU());
    pdus.add(new PDU());

    // Act and Assert
    assertTrue(pduService.processPdus(pdus).isEmpty());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName("Test processPdus(List) with 'pdus'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_thenReturnSizeIsOne() {
    // Arrange
    PduService pduService = new PduService();
    VariableBinding variableBinding = mock(VariableBinding.class);
    when(variableBinding.toValueString()).thenReturn("42");
    when(variableBinding.getOid()).thenReturn(new OID());
    when(variableBinding.getVariable()).thenReturn(new RowCount());

    ArrayList<VariableBinding> variableBindingList = new ArrayList<>();
    variableBindingList.add(variableBinding);
    PDU pdu = mock(PDU.class);
    Mockito.<List<? extends VariableBinding>>when(pdu.getVariableBindings())
        .thenReturn(variableBindingList);
    doNothing().when(pdu).add(Mockito.<VariableBinding>any());
    pdu.add(new VariableBinding());

    ArrayList<PDU> pdus = new ArrayList<>();
    pdus.add(pdu);

    // Act
    Map<OID, String> actualProcessPdusResult = pduService.processPdus(pdus);

    // Assert
    verify(pdu).add(isA(VariableBinding.class));
    verify(pdu).getVariableBindings();
    verify(variableBinding).getOid();
    verify(variableBinding).getVariable();
    verify(variableBinding).toValueString();
    assertEquals(1, actualProcessPdusResult.size());
  }

  /**
   * Test {@link PduService#processPdus(List)} with {@code pdus}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processPdus(List)}
   */
  @Test
  @DisplayName("Test processPdus(List) with 'pdus'; when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PduService.processPdus(List)"})
  void testProcessPdusWithPdus_whenArrayList_thenReturnEmpty() {
    // Arrange
    PduService pduService = new PduService();

    // Act and Assert
    assertTrue(pduService.processPdus(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link JsonObject} (default constructor) size is three.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); given '42'; then JsonObject (default constructor) size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_given42_thenJsonObjectSizeIsThree() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link JsonObject} (default constructor) size is three.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); given '42'; then JsonObject (default constructor) size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_given42_thenJsonObjectSizeIsThree2() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("Property", new JsonArray(3));
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link JsonObject} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); given '42'; then JsonObject (default constructor) size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_given42_thenJsonObjectSizeIsTwo() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue("42", DataType.LONG, "42", result);

    // Assert that nothing has changed
    assertEquals(2, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code .}.
   *   <li>Then {@link JsonObject} (default constructor) size is three.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); given '42'; when '.'; then JsonObject (default constructor) size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_given42_whenDot_thenJsonObjectSizeIsThree() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue(".", DataType.LONG, "42", result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code .}.
   *   <li>Then {@link JsonObject} (default constructor) size is three.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); given '42'; when '.'; then JsonObject (default constructor) size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_given42_whenDot_thenJsonObjectSizeIsThree2() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("Property", new JsonArray(3));
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue(".", DataType.LONG, "42", result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Boolean#FALSE} toString.
   *   <li>Then {@link JsonObject} (default constructor) size is three.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); given '42'; when FALSE toString; then JsonObject (default constructor) size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_given42_whenFalseToString_thenJsonObjectSizeIsThree() {
    // Arrange
    PduService pduService = new PduService();
    String key = Boolean.FALSE.toString();

    JsonObject result = new JsonObject();
    result.add("42", new JsonArray(3));
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue(key, DataType.LONG, "42", result);

    // Assert
    assertEquals(3, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link JsonObject} (default constructor) add {@code .} and {@link
   *       JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); given '.'; when JsonObject (default constructor) add '.' and JsonArray(int) with capacity is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_givenDot_whenJsonObjectAddDotAndJsonArrayWithCapacityIsThree() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add(".", new JsonArray(3));

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(2, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   *   <li>Then {@link JsonObject} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); given 'Property'; then JsonObject (default constructor) size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_givenProperty_thenJsonObjectSizeIsTwo() {
    // Arrange
    PduService pduService = new PduService();

    JsonObject result = new JsonObject();
    result.add("Property", new JsonArray(3));

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(2, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); when 'BOOLEAN'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenBoolean_thenThrowIllegalArgumentException() {
    // Arrange
    PduService pduService = new PduService();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pduService.processValue("Key", DataType.BOOLEAN, "42", new JsonObject()));
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   *   <li>Then {@link JsonObject} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); when JsonObject (default constructor); then JsonObject (default constructor) size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenJsonObject_thenJsonObjectSizeIsOne() {
    // Arrange
    PduService pduService = new PduService();
    JsonObject result = new JsonObject();

    // Act
    pduService.processValue("Key", DataType.LONG, "42", result);

    // Assert
    assertEquals(1, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then {@link JsonObject} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); when 'STRING'; then JsonObject (default constructor) size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenString_thenJsonObjectSizeIsOne() {
    // Arrange
    PduService pduService = new PduService();
    JsonObject result = new JsonObject();

    // Act
    pduService.processValue("Key", DataType.STRING, "42", result);

    // Assert
    assertEquals(1, result.size());
    assertFalse(result.isEmpty());
  }

  /**
   * Test {@link PduService#processValue(String, DataType, String, JsonObject)}.
   *
   * <ul>
   *   <li>When {@link Boolean#TRUE} toString.
   *   <li>Then {@link JsonObject} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link PduService#processValue(String, DataType, String, JsonObject)}
   */
  @Test
  @DisplayName(
      "Test processValue(String, DataType, String, JsonObject); when TRUE toString; then JsonObject (default constructor) size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PduService.processValue(String, DataType, String, JsonObject)"})
  void testProcessValue_whenTrueToString_thenJsonObjectSizeIsOne() {
    // Arrange
    PduService pduService = new PduService();
    String value = Boolean.TRUE.toString();
    JsonObject result = new JsonObject();

    // Act
    pduService.processValue("Key", DataType.BOOLEAN, value, result);

    // Assert
    assertEquals(1, result.size());
    assertFalse(result.isEmpty());
  }
}
