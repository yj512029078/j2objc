/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.j2objc.javac;

import javax.lang.model.type.ArrayType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;

class JdtArrayType extends JdtTypeMirror implements ArrayType {

  JdtArrayType(JdtTypeBinding binding) {
    super(binding);
    assert binding.isArray();
  }

  @Override
  public TypeKind getKind() {
    return TypeKind.ARRAY;
  }

  @Override
  public <R, P> R accept(TypeVisitor<R, P> v, P p) {
    return v.visitArray(this, p);
  }

  @Override
  public TypeMirror getComponentType() {
    return BindingConverter.getType(((JdtTypeBinding) binding).getComponentType());
  }
}
