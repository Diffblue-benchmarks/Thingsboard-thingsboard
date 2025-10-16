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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.ModelConstants;

public class DomainOauth2ClientCompositeKeyDiffblueTest {
  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}, and {@link
   * DomainOauth2ClientCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link DomainOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey2 =
        new DomainOauth2ClientCompositeKey();

    // Act and Assert
    assertEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey2);
    assertEquals(
        domainOauth2ClientCompositeKey.hashCode(), domainOauth2ClientCompositeKey2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}, and {@link
   * DomainOauth2ClientCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link DomainOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey2 =
        new DomainOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey2);
    assertEquals(
        domainOauth2ClientCompositeKey.hashCode(), domainOauth2ClientCompositeKey2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}, and {@link
   * DomainOauth2ClientCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link DomainOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();

    // Act and Assert
    assertEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey);
    int expectedHashCodeResult = domainOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientCompositeKey.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientCompositeKey, new DomainOauth2ClientCompositeKey());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();

    // Act and Assert
    assertNotEquals(
        domainOauth2ClientCompositeKey,
        new DomainOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID));
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();
    domainOauth2ClientCompositeKey.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientCompositeKey, new DomainOauth2ClientCompositeKey());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();

    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey2 =
        new DomainOauth2ClientCompositeKey();
    domainOauth2ClientCompositeKey2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey2);
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainOauth2ClientCompositeKey(), null);
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DomainOauth2ClientCompositeKey(), "Different type to DomainOauth2ClientCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#DomainOauth2ClientCompositeKey()}
   *   <li>{@link DomainOauth2ClientCompositeKey#setDomainId(UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#setOauth2ClientId(UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#toString()}
   *   <li>{@link DomainOauth2ClientCompositeKey#getDomainId()}
   *   <li>{@link DomainOauth2ClientCompositeKey#getOauth2ClientId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DomainOauth2ClientCompositeKey.<init>()",
    "void DomainOauth2ClientCompositeKey.<init>(UUID, UUID)",
    "UUID DomainOauth2ClientCompositeKey.getDomainId()",
    "UUID DomainOauth2ClientCompositeKey.getOauth2ClientId()",
    "void DomainOauth2ClientCompositeKey.setDomainId(UUID)",
    "void DomainOauth2ClientCompositeKey.setOauth2ClientId(UUID)",
    "String DomainOauth2ClientCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DomainOauth2ClientCompositeKey actualDomainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();
    actualDomainOauth2ClientCompositeKey.setDomainId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualDomainOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualDomainOauth2ClientCompositeKey.toString();
    UUID actualDomainId = actualDomainOauth2ClientCompositeKey.getDomainId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDomainId.toString());
    assertEquals(
        "DomainOauth2ClientCompositeKey(domainId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId=13814000"
            + "-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(oauth2ClientId, actualDomainId);
    assertSame(oauth2ClientId, actualDomainOauth2ClientCompositeKey.getOauth2ClientId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#DomainOauth2ClientCompositeKey(UUID, UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#setDomainId(UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#setOauth2ClientId(UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#toString()}
   *   <li>{@link DomainOauth2ClientCompositeKey#getDomainId()}
   *   <li>{@link DomainOauth2ClientCompositeKey#getOauth2ClientId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DomainOauth2ClientCompositeKey.<init>()",
    "void DomainOauth2ClientCompositeKey.<init>(UUID, UUID)",
    "UUID DomainOauth2ClientCompositeKey.getDomainId()",
    "UUID DomainOauth2ClientCompositeKey.getOauth2ClientId()",
    "void DomainOauth2ClientCompositeKey.setDomainId(UUID)",
    "void DomainOauth2ClientCompositeKey.setOauth2ClientId(UUID)",
    "String DomainOauth2ClientCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    DomainOauth2ClientCompositeKey actualDomainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    actualDomainOauth2ClientCompositeKey.setDomainId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualDomainOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualDomainOauth2ClientCompositeKey.toString();
    UUID actualDomainId = actualDomainOauth2ClientCompositeKey.getDomainId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDomainId.toString());
    assertEquals(
        "DomainOauth2ClientCompositeKey(domainId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId=13814000"
            + "-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertSame(oauth2ClientId, actualDomainId);
    assertSame(oauth2ClientId, actualDomainOauth2ClientCompositeKey.getOauth2ClientId());
  }
}
