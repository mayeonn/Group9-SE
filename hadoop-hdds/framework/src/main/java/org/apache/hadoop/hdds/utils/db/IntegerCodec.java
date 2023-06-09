/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hdds.utils.db;

import com.google.common.primitives.Ints;

import javax.annotation.Nonnull;
import java.util.function.IntFunction;

/**
 * Codec to convert Integer to/from byte array.
 */
public final class IntegerCodec implements Codec<Integer> {
  @Override
  public boolean supportCodecBuffer() {
    return true;
  }

  @Override
  public CodecBuffer toCodecBuffer(@Nonnull Integer object,
      IntFunction<CodecBuffer> allocator) {
    return allocator.apply(Integer.BYTES).putInt(object);
  }

  @Override
  public Integer fromCodecBuffer(@Nonnull CodecBuffer buffer) {
    return buffer.asReadOnlyByteBuffer().getInt();
  }

  @Override
  public byte[] toPersistedFormat(Integer object) {
    return Ints.toByteArray(object);
  }

  @Override
  public Integer fromPersistedFormat(byte[] rawData) {
    return Ints.fromByteArray(rawData);
  }

  @Override
  public Integer copyObject(Integer object) {
    return object;
  }
}
