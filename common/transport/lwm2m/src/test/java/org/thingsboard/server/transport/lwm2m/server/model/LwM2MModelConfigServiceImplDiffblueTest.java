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
package org.thingsboard.server.transport.lwm2m.server.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MModelConfigStore;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class LwM2MModelConfigServiceImplDiffblueTest {
  @InjectMocks
  private LwM2MModelConfigServiceImpl lwM2MModelConfigServiceImpl;

  @Mock
  private TbLwM2MModelConfigStore tbLwM2MModelConfigStore;

  /**
   * Test {@link LwM2MModelConfigServiceImpl#init()}.
   * <p>
   * Method under test: {@link LwM2MModelConfigServiceImpl#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MModelConfigServiceImpl.init()"})
  void testInit() {
    // Arrange
    ArrayList<LwM2MModelConfig> lwM2MModelConfigList = new ArrayList<>();
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig("https://config.us-east-2.amazonaws.com");
    lwM2MModelConfigList.add(lwM2MModelConfig);
    when(tbLwM2MModelConfigStore.getAll()).thenReturn(lwM2MModelConfigList);

    // Act
    lwM2MModelConfigServiceImpl.init();

    // Assert
    verify(tbLwM2MModelConfigStore).getAll();
    ConcurrentMap<String, LwM2MModelConfig> stringLwM2MModelConfigMap = lwM2MModelConfigServiceImpl.currentModelConfigs;
    assertEquals(1, stringLwM2MModelConfigMap.size());
    assertSame(lwM2MModelConfig, stringLwM2MModelConfigMap.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MModelConfigServiceImpl#init()}.
   * <p>
   * Method under test: {@link LwM2MModelConfigServiceImpl#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MModelConfigServiceImpl.init()"})
  void testInit2() {
    // Arrange
    ArrayList<LwM2MModelConfig> lwM2MModelConfigList = new ArrayList<>();
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig("https://config.us-east-2.amazonaws.com");
    lwM2MModelConfigList.add(lwM2MModelConfig);
    lwM2MModelConfigList.add(new LwM2MModelConfig("https://config.us-east-2.amazonaws.com"));
    when(tbLwM2MModelConfigStore.getAll()).thenReturn(lwM2MModelConfigList);

    // Act
    lwM2MModelConfigServiceImpl.init();

    // Assert
    verify(tbLwM2MModelConfigStore).getAll();
    ConcurrentMap<String, LwM2MModelConfig> stringLwM2MModelConfigMap = lwM2MModelConfigServiceImpl.currentModelConfigs;
    assertEquals(1, stringLwM2MModelConfigMap.size());
    assertSame(lwM2MModelConfig, stringLwM2MModelConfigMap.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MModelConfigServiceImpl#init()}.
   * <p>
   * Method under test: {@link LwM2MModelConfigServiceImpl#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MModelConfigServiceImpl.init()"})
  void testInit3() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = mock(LwM2MModelConfig.class);
    when(lwM2MModelConfig.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    ArrayList<LwM2MModelConfig> lwM2MModelConfigList = new ArrayList<>();
    lwM2MModelConfigList.add(lwM2MModelConfig);
    when(tbLwM2MModelConfigStore.getAll()).thenReturn(lwM2MModelConfigList);

    // Act
    lwM2MModelConfigServiceImpl.init();

    // Assert
    verify(lwM2MModelConfig).getEndpoint();
    verify(tbLwM2MModelConfigStore).getAll();
    ConcurrentMap<String, LwM2MModelConfig> stringLwM2MModelConfigMap = lwM2MModelConfigServiceImpl.currentModelConfigs;
    assertEquals(1, stringLwM2MModelConfigMap.size());
    assertTrue(stringLwM2MModelConfigMap.containsKey("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MModelConfigServiceImpl#init()}.
   * <ul>
   *   <li>Then {@link LwM2MModelConfigServiceImpl} {@link LwM2MModelConfigServiceImpl#currentModelConfigs} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MModelConfigServiceImpl#init()}
   */
  @Test
  @DisplayName("Test init(); then LwM2MModelConfigServiceImpl currentModelConfigs Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MModelConfigServiceImpl.init()"})
  void testInit_thenLwM2MModelConfigServiceImplCurrentModelConfigsEmpty() {
    // Arrange
    when(tbLwM2MModelConfigStore.getAll()).thenReturn(new ArrayList<>());

    // Act
    lwM2MModelConfigServiceImpl.init();

    // Assert
    verify(tbLwM2MModelConfigStore).getAll();
    assertTrue(lwM2MModelConfigServiceImpl.currentModelConfigs.isEmpty());
  }
}
