// Copyright (c) 2003-present, Jodd Team (http://jodd.org)
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// 1. Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.
//
// 2. Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.

package jodd.core;

import jodd.util.StringPool;
import jodd.util.cl.ClassLoaderStrategy;
import jodd.util.cl.DefaultClassLoaderStrategy;

import java.security.Security;
import java.util.Objects;

/**
 * Jodd CORE module.
 */
public class JoddCore {

	private static final JoddCore instance = new JoddCore();

	public static JoddCore defaults() {
		return instance;
	}

	static {
		// Starting from Java8 u151, the `Unlimited Strength Jurisdiction Policy Files`
		// are included with Java, but has to be enabled.
		// They are enabled on Java9 by default.
		Security.setProperty("crypto.policy", "unlimited");
	}

	// ---------------------------------------------------------------- settings

	private String tempFilePrefix = "jodd-";
	private String encoding = StringPool.UTF_8;
	private int ioBufferSize = 16384;
	private boolean unsafeUsageEnabled = true;
	private ClassLoaderStrategy classLoaderStrategy = new DefaultClassLoaderStrategy();

	/**
	 * Returns default prefix for temporary files.
	 */
	public String getTempFilePrefix() {
		return tempFilePrefix;
	}

	/**
	 * Sets default file prefix.
	 */
	public void setTempFilePrefix(final String tempFilePrefix) {
		this.tempFilePrefix = tempFilePrefix;
	}

	/**
	 * Returns default encoding used across the Jodd classes. "UTF-8".
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * Sets new encoding that is used across the Jodd library.
	 */
	public void setEncoding(final String encoding) {
		this.encoding = encoding;
	}

	/**
	 * Returns buffer size for various IO operations.
	 */
	public int getIoBufferSize() {
		return ioBufferSize;
	}

	/**
	 * Sets new buffer size for various IO operations.
	 */
	public void setIoBufferSize(final int ioBufferSize) {
		this.ioBufferSize = ioBufferSize;
	}

	/**
	 * Returns {@code true} if {@code Unsafe} is enabled (if system detects so). Enabled by default.
	 */
	public boolean isUnsafeUsageEnabled() {
		return unsafeUsageEnabled;
	}

	/**
	 * Enables or disables usage of {@code Unsafe}.
	 */
	public void setUnsafeUsageEnabled(final boolean unsafeUsed) {
		this.unsafeUsageEnabled = unsafeUsed;
	}

	/**
	 * Returns the classloader strategy implementation.
	 */
	public ClassLoaderStrategy getClassLoaderStrategy() {
		return classLoaderStrategy;
	}

	/**
	 * Defines classloader strategy implementation.
	 */
	public JoddCore setClassLoaderStrategy(final ClassLoaderStrategy classLoaderStrategy) {
		Objects.requireNonNull(classLoaderStrategy);
		this.classLoaderStrategy = classLoaderStrategy;
		return this;
	}

}