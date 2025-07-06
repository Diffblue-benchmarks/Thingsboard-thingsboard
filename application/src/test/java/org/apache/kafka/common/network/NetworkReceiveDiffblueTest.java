package org.apache.kafka.common.network;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.ScatteringByteChannel;
import org.apache.kafka.common.memory.GarbageCollectedMemoryPool;
import org.apache.kafka.common.memory.MemoryPool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {NetworkReceive.class})
@ExtendWith(SpringExtension.class)
class NetworkReceiveDiffblueTest {
  @Autowired private NetworkReceive networkReceive;

  /**
   * Test {@link NetworkReceive#NetworkReceive()}.
   *
   * <p>Method under test: {@link NetworkReceive#NetworkReceive()}
   */
  @Test
  @DisplayName("Test new NetworkReceive()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NetworkReceive.<init>()"})
  void testNewNetworkReceive() {
    // Arrange and Act
    NetworkReceive actualNetworkReceive = new NetworkReceive();

    // Assert
    assertNull(actualNetworkReceive.payload());
    assertEquals(NetworkReceive.UNKNOWN_SOURCE, actualNetworkReceive.source());
  }

  /**
   * Test {@link NetworkReceive#NetworkReceive(String)}.
   *
   * <p>Method under test: {@link NetworkReceive#NetworkReceive(String)}
   */
  @Test
  @DisplayName("Test new NetworkReceive(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NetworkReceive.<init>(String)"})
  void testNewNetworkReceive2() {
    // Arrange and Act
    NetworkReceive actualNetworkReceive = new NetworkReceive("Source");

    // Assert
    assertEquals("Source", actualNetworkReceive.source());
    assertNull(actualNetworkReceive.payload());
  }

  /**
   * Test {@link NetworkReceive#NetworkReceive(String, ByteBuffer)}.
   *
   * <p>Method under test: {@link NetworkReceive#NetworkReceive(String, ByteBuffer)}
   */
  @Test
  @DisplayName("Test new NetworkReceive(String, ByteBuffer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NetworkReceive.<init>(String, ByteBuffer)"})
  void testNewNetworkReceive3() throws UnsupportedEncodingException {
    // Arrange
    ByteBuffer buffer = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));

    // Act
    NetworkReceive actualNetworkReceive = new NetworkReceive("Source", buffer);

    // Assert
    assertEquals("Source", actualNetworkReceive.source());
    assertEquals(12, actualNetworkReceive.size());
    assertSame(buffer, actualNetworkReceive.payload());
  }

  /**
   * Test {@link NetworkReceive#NetworkReceive(int, String)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link NetworkReceive#NetworkReceive(int, String)}
   */
  @Test
  @DisplayName("Test new NetworkReceive(int, String); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NetworkReceive.<init>(int, String)"})
  void testNewNetworkReceive_whenThree() {
    // Arrange and Act
    NetworkReceive actualNetworkReceive = new NetworkReceive(3, "Source");

    // Assert
    assertEquals("Source", actualNetworkReceive.source());
    assertNull(actualNetworkReceive.payload());
  }

  /**
   * Test {@link NetworkReceive#NetworkReceive(int, String, MemoryPool)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link NetworkReceive#NetworkReceive(int, String, MemoryPool)}
   */
  @Test
  @DisplayName("Test new NetworkReceive(int, String, MemoryPool); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NetworkReceive.<init>(int, String, MemoryPool)"})
  void testNewNetworkReceive_whenThree2() {
    // Arrange and Act
    NetworkReceive actualNetworkReceive =
        new NetworkReceive(3, "Source", new GarbageCollectedMemoryPool(3L, 3, true, null));

    // Assert
    assertEquals("Source", actualNetworkReceive.source());
    assertNull(actualNetworkReceive.payload());
  }

  /**
   * Test {@link NetworkReceive#NetworkReceive(int, String)}.
   *
   * <ul>
   *   <li>When {@link NetworkReceive#UNLIMITED}.
   * </ul>
   *
   * <p>Method under test: {@link NetworkReceive#NetworkReceive(int, String)}
   */
  @Test
  @DisplayName("Test new NetworkReceive(int, String); when UNLIMITED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NetworkReceive.<init>(int, String)"})
  void testNewNetworkReceive_whenUnlimited() {
    // Arrange and Act
    NetworkReceive actualNetworkReceive = new NetworkReceive(NetworkReceive.UNLIMITED, "Source");

    // Assert
    assertEquals("Source", actualNetworkReceive.source());
    assertNull(actualNetworkReceive.payload());
  }

  /**
   * Test {@link NetworkReceive#NetworkReceive(int, String, MemoryPool)}.
   *
   * <ul>
   *   <li>When {@link NetworkReceive#UNLIMITED}.
   * </ul>
   *
   * <p>Method under test: {@link NetworkReceive#NetworkReceive(int, String, MemoryPool)}
   */
  @Test
  @DisplayName("Test new NetworkReceive(int, String, MemoryPool); when UNLIMITED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NetworkReceive.<init>(int, String, MemoryPool)"})
  void testNewNetworkReceive_whenUnlimited2() {
    // Arrange and Act
    NetworkReceive actualNetworkReceive =
        new NetworkReceive(
            NetworkReceive.UNLIMITED, "Source", new GarbageCollectedMemoryPool(3L, 3, true, null));

    // Assert
    assertEquals("Source", actualNetworkReceive.source());
    assertNull(actualNetworkReceive.payload());
  }

  /**
   * Test {@link NetworkReceive#source()}.
   *
   * <p>Method under test: {@link NetworkReceive#source()}
   */
  @Test
  @DisplayName("Test source()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NetworkReceive.source()"})
  void testSource() {
    // Arrange, Act and Assert
    assertEquals(NetworkReceive.UNKNOWN_SOURCE, new NetworkReceive().source());
  }

  /**
   * Test {@link NetworkReceive#complete()}.
   *
   * <p>Method under test: {@link NetworkReceive#complete()}
   */
  @Test
  @DisplayName("Test complete()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NetworkReceive.complete()"})
  void testComplete() {
    // Arrange, Act and Assert
    assertFalse(networkReceive.complete());
  }

  /**
   * Test {@link NetworkReceive#readFrom(ScatteringByteChannel)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PlaintextTransportLayer} {@link PlaintextTransportLayer#read(ByteBuffer)}
   *       return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NetworkReceive#readFrom(ScatteringByteChannel)}
   */
  @Test
  @DisplayName(
      "Test readFrom(ScatteringByteChannel); given one; when PlaintextTransportLayer read(ByteBuffer) return one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long NetworkReceive.readFrom(ScatteringByteChannel)"})
  void testReadFrom_givenOne_whenPlaintextTransportLayerReadReturnOne_thenReturnOne()
      throws IOException {
    // Arrange
    PlaintextTransportLayer channel = mock(PlaintextTransportLayer.class);
    when(channel.read(Mockito.<ByteBuffer>any())).thenReturn(1);

    // Act
    long actualReadFromResult = networkReceive.readFrom(channel);

    // Assert
    verify(channel).read(isA(ByteBuffer.class));
    assertEquals(1L, actualReadFromResult);
  }

  /**
   * Test {@link NetworkReceive#readFrom(ScatteringByteChannel)}.
   *
   * <ul>
   *   <li>Given {@link NetworkReceive#UNLIMITED}.
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link NetworkReceive#readFrom(ScatteringByteChannel)}
   */
  @Test
  @DisplayName("Test readFrom(ScatteringByteChannel); given UNLIMITED; then throw EOFException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long NetworkReceive.readFrom(ScatteringByteChannel)"})
  void testReadFrom_givenUnlimited_thenThrowEOFException() throws IOException {
    // Arrange
    PlaintextTransportLayer channel = mock(PlaintextTransportLayer.class);
    when(channel.read(Mockito.<ByteBuffer>any())).thenReturn(NetworkReceive.UNLIMITED);

    // Act and Assert
    assertThrows(EOFException.class, () -> networkReceive.readFrom(channel));
    verify(channel).read(isA(ByteBuffer.class));
  }

  /**
   * Test {@link NetworkReceive#requiredMemoryAmountKnown()}.
   *
   * <p>Method under test: {@link NetworkReceive#requiredMemoryAmountKnown()}
   */
  @Test
  @DisplayName("Test requiredMemoryAmountKnown()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NetworkReceive.requiredMemoryAmountKnown()"})
  void testRequiredMemoryAmountKnown() {
    // Arrange, Act and Assert
    assertFalse(networkReceive.requiredMemoryAmountKnown());
  }

  /**
   * Test {@link NetworkReceive#memoryAllocated()}.
   *
   * <p>Method under test: {@link NetworkReceive#memoryAllocated()}
   */
  @Test
  @DisplayName("Test memoryAllocated()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NetworkReceive.memoryAllocated()"})
  void testMemoryAllocated() {
    // Arrange, Act and Assert
    assertFalse(networkReceive.memoryAllocated());
  }

  /**
   * Test {@link NetworkReceive#payload()}.
   *
   * <p>Method under test: {@link NetworkReceive#payload()}
   */
  @Test
  @DisplayName("Test payload()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteBuffer NetworkReceive.payload()"})
  void testPayload() {
    // Arrange, Act and Assert
    assertNull(networkReceive.payload());
  }

  /**
   * Test {@link NetworkReceive#bytesRead()}.
   *
   * <p>Method under test: {@link NetworkReceive#bytesRead()}
   */
  @Test
  @DisplayName("Test bytesRead()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int NetworkReceive.bytesRead()"})
  void testBytesRead() {
    // Arrange, Act and Assert
    assertEquals(0, networkReceive.bytesRead());
  }
}
