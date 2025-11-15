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
package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RepositorySettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    RepositorySettings repositorySettings2 = new RepositorySettings();

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setRepositoryUri("Repository Uri");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setRepositoryUri("Repository Uri");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setUsername("janedoe");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setUsername("janedoe");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPassword("iloveyou");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPassword("iloveyou");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyFileName("foo.txt");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKeyFileName("foo.txt");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKey("Private Key");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKey("Private Key");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyPassword("iloveyou");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKeyPassword("iloveyou");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setDefaultBranch("janedoe/featurebranch");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setDefaultBranch("janedoe/featurebranch");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings.hashCode());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RepositorySettings(), 1);
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setRepositoryUri("Repository Uri");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyFileName("foo.txt");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKey("Private Key");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setDefaultBranch("janedoe/featurebranch");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setReadOnly(true);

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setShowMergeCommits(true);

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setLocalOnly(true);

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setRepositoryUri("Repository Uri");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKeyFileName("foo.txt");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKey("Private Key");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setDefaultBranch("janedoe/featurebranch");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RepositorySettings(), null);
  }

  /**
   * Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RepositorySettings(), "Different type to RepositorySettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettings#RepositorySettings()}
   *   <li>{@link RepositorySettings#setAuthMethod(RepositoryAuthMethod)}
   *   <li>{@link RepositorySettings#setDefaultBranch(String)}
   *   <li>{@link RepositorySettings#setLocalOnly(boolean)}
   *   <li>{@link RepositorySettings#setPassword(String)}
   *   <li>{@link RepositorySettings#setPrivateKey(String)}
   *   <li>{@link RepositorySettings#setPrivateKeyFileName(String)}
   *   <li>{@link RepositorySettings#setPrivateKeyPassword(String)}
   *   <li>{@link RepositorySettings#setReadOnly(boolean)}
   *   <li>{@link RepositorySettings#setRepositoryUri(String)}
   *   <li>{@link RepositorySettings#setShowMergeCommits(boolean)}
   *   <li>{@link RepositorySettings#setUsername(String)}
   *   <li>{@link RepositorySettings#toString()}
   *   <li>{@link RepositorySettings#getAuthMethod()}
   *   <li>{@link RepositorySettings#getDefaultBranch()}
   *   <li>{@link RepositorySettings#getPassword()}
   *   <li>{@link RepositorySettings#getPrivateKey()}
   *   <li>{@link RepositorySettings#getPrivateKeyFileName()}
   *   <li>{@link RepositorySettings#getPrivateKeyPassword()}
   *   <li>{@link RepositorySettings#getRepositoryUri()}
   *   <li>{@link RepositorySettings#getUsername()}
   *   <li>{@link RepositorySettings#isLocalOnly()}
   *   <li>{@link RepositorySettings#isReadOnly()}
   *   <li>{@link RepositorySettings#isShowMergeCommits()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RepositorySettings actualRepositorySettings = new RepositorySettings();
    actualRepositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    actualRepositorySettings.setDefaultBranch("janedoe/featurebranch");
    actualRepositorySettings.setLocalOnly(true);
    actualRepositorySettings.setPassword("iloveyou");
    actualRepositorySettings.setPrivateKey("Private Key");
    actualRepositorySettings.setPrivateKeyFileName("foo.txt");
    actualRepositorySettings.setPrivateKeyPassword("iloveyou");
    actualRepositorySettings.setReadOnly(true);
    actualRepositorySettings.setRepositoryUri("Repository Uri");
    actualRepositorySettings.setShowMergeCommits(true);
    actualRepositorySettings.setUsername("janedoe");
    String actualToStringResult = actualRepositorySettings.toString();
    RepositoryAuthMethod actualAuthMethod = actualRepositorySettings.getAuthMethod();
    String actualDefaultBranch = actualRepositorySettings.getDefaultBranch();
    String actualPassword = actualRepositorySettings.getPassword();
    String actualPrivateKey = actualRepositorySettings.getPrivateKey();
    String actualPrivateKeyFileName = actualRepositorySettings.getPrivateKeyFileName();
    String actualPrivateKeyPassword = actualRepositorySettings.getPrivateKeyPassword();
    String actualRepositoryUri = actualRepositorySettings.getRepositoryUri();
    String actualUsername = actualRepositorySettings.getUsername();
    boolean actualIsLocalOnlyResult = actualRepositorySettings.isLocalOnly();
    boolean actualIsReadOnlyResult = actualRepositorySettings.isReadOnly();

    // Assert that nothing has changed
    assertEquals("Private Key", actualPrivateKey);
    assertEquals("Repository Uri", actualRepositoryUri);
    assertEquals(
        "RepositorySettings(repositoryUri=Repository Uri, authMethod=USERNAME_PASSWORD, username=janedoe,"
            + " password=iloveyou, privateKeyFileName=foo.txt, privateKey=Private Key, privateKeyPassword=iloveyou,"
            + " defaultBranch=janedoe/featurebranch, readOnly=true, showMergeCommits=true, localOnly=true)",
        actualToStringResult);
    assertEquals("foo.txt", actualPrivateKeyFileName);
    assertEquals("iloveyou", actualPassword);
    assertEquals("iloveyou", actualPrivateKeyPassword);
    assertEquals("janedoe", actualUsername);
    assertEquals("janedoe/featurebranch", actualDefaultBranch);
    assertEquals(RepositoryAuthMethod.USERNAME_PASSWORD, actualAuthMethod);
    assertTrue(actualIsLocalOnlyResult);
    assertTrue(actualIsReadOnlyResult);
    assertTrue(actualRepositorySettings.isShowMergeCommits());
  }

  /**
   * Method under test:
   * {@link RepositorySettings#RepositorySettings(RepositorySettings)}
   */
  @Test
  void testNewRepositorySettings() {
    // Arrange
    RepositorySettings settings = new RepositorySettings();

    // Act and Assert
    assertEquals(settings, new RepositorySettings(settings));
  }

  /**
   * Method under test:
   * {@link RepositorySettings#RepositorySettings(RepositorySettings)}
   */
  @Test
  void testNewRepositorySettings2() {
    // Arrange
    RepositorySettings settings = new RepositorySettings();
    settings.setReadOnly(true);

    // Act and Assert
    assertEquals(settings, new RepositorySettings(settings));
  }
}
