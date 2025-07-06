package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.secure.TbX509DtlsSessionInfo;

class TbL2M2MDtlsSessionInMemoryStoreDiffblueTest {
  /**
   * Test {@link TbL2M2MDtlsSessionInMemoryStore#put(String, TbX509DtlsSessionInfo)}.
   *
   * <p>Method under test: {@link TbL2M2MDtlsSessionInMemoryStore#put(String,
   * TbX509DtlsSessionInfo)}
   */
  @Test
  @DisplayName("Test put(String, TbX509DtlsSessionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbL2M2MDtlsSessionInMemoryStore.put(String, TbX509DtlsSessionInfo)"})
  void testPut() {
    // Arrange
    TbL2M2MDtlsSessionInMemoryStore tbL2M2MDtlsSessionInMemoryStore =
        new TbL2M2MDtlsSessionInMemoryStore();
    TbX509DtlsSessionInfo msg = mock(TbX509DtlsSessionInfo.class);

    // Act
    tbL2M2MDtlsSessionInMemoryStore.put("https://config.us-east-2.amazonaws.com", msg);

    // Assert
    assertSame(msg, tbL2M2MDtlsSessionInMemoryStore.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbL2M2MDtlsSessionInMemoryStore#get(String)}.
   *
   * <p>Method under test: {@link TbL2M2MDtlsSessionInMemoryStore#get(String)}
   */
  @Test
  @DisplayName("Test get(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbX509DtlsSessionInfo TbL2M2MDtlsSessionInMemoryStore.get(String)"})
  void testGet() {
    // Arrange, Act and Assert
    assertNull(new TbL2M2MDtlsSessionInMemoryStore().get("https://config.us-east-2.amazonaws.com"));
  }
}
