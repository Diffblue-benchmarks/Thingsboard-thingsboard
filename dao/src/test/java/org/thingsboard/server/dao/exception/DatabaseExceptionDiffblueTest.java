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
package org.thingsboard.server.dao.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DatabaseExceptionDiffblueTest {
  /**
   * Test {@link DatabaseException#DatabaseException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseException#DatabaseException()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DatabaseException.<init>()",
    "void DatabaseException.<init>(String)",
    "void DatabaseException.<init>(String, Throwable)",
    "void DatabaseException.<init>(Throwable)"
  })
  public void testNewDatabaseException_thenReturnMessageIsNull() {
    // Arrange and Act
    DatabaseException actualDatabaseException = new DatabaseException();

    // Assert
    assertNull(actualDatabaseException.getMessage());
    assertNull(actualDatabaseException.getCause());
    assertEquals(0, actualDatabaseException.getSuppressed().length);
  }

  /**
   * Test {@link DatabaseException#DatabaseException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseException#DatabaseException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DatabaseException.<init>()",
    "void DatabaseException.<init>(String)",
    "void DatabaseException.<init>(String, Throwable)",
    "void DatabaseException.<init>(Throwable)"
  })
  public void testNewDatabaseException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    DatabaseException actualDatabaseException = new DatabaseException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDatabaseException.getMessage());
    assertNull(actualDatabaseException.getCause());
    assertEquals(0, actualDatabaseException.getSuppressed().length);
  }

  /**
   * Test {@link DatabaseException#DatabaseException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseException#DatabaseException(String, Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DatabaseException.<init>()",
    "void DatabaseException.<init>(String)",
    "void DatabaseException.<init>(String, Throwable)",
    "void DatabaseException.<init>(Throwable)"
  })
  public void testNewDatabaseException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DatabaseException actualDatabaseException = new DatabaseException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualDatabaseException.getMessage());
    assertEquals(0, actualDatabaseException.getSuppressed().length);
    assertSame(cause, actualDatabaseException.getCause());
  }

  /**
   * Test {@link DatabaseException#DatabaseException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseException#DatabaseException(Throwable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DatabaseException.<init>()",
    "void DatabaseException.<init>(String)",
    "void DatabaseException.<init>(String, Throwable)",
    "void DatabaseException.<init>(Throwable)"
  })
  public void testNewDatabaseException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DatabaseException actualDatabaseException = new DatabaseException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualDatabaseException.getMessage());
    assertEquals(0, actualDatabaseException.getSuppressed().length);
    assertSame(cause, actualDatabaseException.getCause());
  }
}
