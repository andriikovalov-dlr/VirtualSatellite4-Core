package org.eclipse.emf.codegen.ecore.templates.edit;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class ItemProvider
{
  protected static String nl;
  public static synchronized ItemProvider create(String lineSeparator)
  {
    nl = lineSeparator;
    ItemProvider result = new ItemProvider();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = "/**";
  protected final String TEXT_5 = NL + " * ";
  protected final String TEXT_6 = NL + " */" + NL + "package ";
  protected final String TEXT_7 = ";" + NL + NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + NL + "/**" + NL + " * This is the item provider adapter for a {@link ";
  protected final String TEXT_10 = "} object." + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_11 = " ";
  protected final String TEXT_12 = "extends ";
  protected final String TEXT_13 = NL + "\textends ";
  protected final String TEXT_14 = NL + "\timplements";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = ",";
  protected final String TEXT_17 = NL + "{";
  protected final String TEXT_18 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_19 = " copyright = ";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + "\t/**" + NL + "\t * This constructs an instance from a factory and a notifier." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_23 = "(AdapterFactory adapterFactory)" + NL + "\t{" + NL + "\t\tsuper(adapterFactory);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * This returns the property descriptors for the adapted class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_24 = NL + "\t@Override";
  protected final String TEXT_25 = NL + "\tpublic ";
  protected final String TEXT_26 = " getPropertyDescriptors(Object object)" + NL + "\t{" + NL + "\t\tif (itemPropertyDescriptors == null)" + NL + "\t\t{" + NL + "\t\t\tsuper.getPropertyDescriptors(object);" + NL;
  protected final String TEXT_27 = NL + "\t\t\tadd";
  protected final String TEXT_28 = "PropertyDescriptor(object);";
  protected final String TEXT_29 = NL + "\t\t}" + NL + "\t\treturn itemPropertyDescriptors;" + NL + "\t}" + NL;
  protected final String TEXT_30 = NL + "\t/**" + NL + "\t * This adds a property descriptor for the ";
  protected final String TEXT_31 = " feature." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void add";
  protected final String TEXT_32 = "PropertyDescriptor(Object object)" + NL + "\t{";
  protected final String TEXT_33 = NL + "\t\titemPropertyDescriptors.add" + NL + "\t\t\t(createItemPropertyDescriptor" + NL + "\t\t\t\t(((";
  protected final String TEXT_34 = ")adapterFactory).getRootAdapterFactory()," + NL + "\t\t\t\t getResourceLocator()," + NL + "\t\t\t\t getString(\"_UI_";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = "_feature\"),";
  protected final String TEXT_37 = NL + "\t\t\t\t getString(\"_UI_PropertyDescriptor_description\", \"_UI_";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = "_feature\", \"_UI_";
  protected final String TEXT_40 = "_type\"),";
  protected final String TEXT_41 = NL + "\t\t\t\t getString(\"_UI_";
  protected final String TEXT_42 = "_";
  protected final String TEXT_43 = "_description\"),";
  protected final String TEXT_44 = NL + "\t\t\t\t ";
  protected final String TEXT_45 = "," + NL + "\t\t\t\t ";
  protected final String TEXT_46 = "," + NL + "\t\t\t\t ";
  protected final String TEXT_47 = "," + NL + "\t\t\t\t ";
  protected final String TEXT_48 = ",";
  protected final String TEXT_49 = NL + "\t\t\t\t null,";
  protected final String TEXT_50 = NL + "\t\t\t\t ";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ",";
  protected final String TEXT_53 = NL + "\t\t\t\t null,";
  protected final String TEXT_54 = NL + "\t\t\t\t getString(\"";
  protected final String TEXT_55 = "\"),";
  protected final String TEXT_56 = NL + "\t\t\t\t null));";
  protected final String TEXT_57 = NL + "\t\t\t\t new String[] {";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\"";
  protected final String TEXT_59 = "\"";
  protected final String TEXT_60 = ",";
  protected final String TEXT_61 = NL + "\t\t\t\t }));";
  protected final String TEXT_62 = NL + "\t}" + NL;
  protected final String TEXT_63 = NL + "\t/**" + NL + "\t * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an" + NL + "\t * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or" + NL + "\t * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_64 = NL + "\t@Override";
  protected final String TEXT_65 = NL + "\tpublic ";
  protected final String TEXT_66 = " getChildrenFeatures(Object object)" + NL + "\t{" + NL + "\t\tif (childrenFeatures == null)" + NL + "\t\t{" + NL + "\t\t\tsuper.getChildrenFeatures(object);";
  protected final String TEXT_67 = NL + "\t\t\tchildrenFeatures.add(";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\t\t}" + NL + "\t\treturn childrenFeatures;" + NL + "\t}" + NL;
  protected final String TEXT_70 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_71 = NL + "\t@Override";
  protected final String TEXT_72 = NL + "\tprotected ";
  protected final String TEXT_73 = " getChildFeature(Object object, Object child)" + NL + "\t{" + NL + "\t\t// Check the type of the specified child object and return the proper feature to use for" + NL + "\t\t// adding (see {@link AddCommand}) it as a child." + NL + "" + NL + "\t\treturn super.getChildFeature(object, child);" + NL + "\t}" + NL;
  protected final String TEXT_74 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_75 = NL + "\t@Override";
  protected final String TEXT_76 = NL + "\tpublic boolean hasChildren(Object object)" + NL + "\t{" + NL + "\t\treturn hasChildren(object, ";
  protected final String TEXT_77 = ");" + NL + "\t}" + NL;
  protected final String TEXT_78 = NL + "\t/**" + NL + "\t * *********************************" + NL + "\t * VirSat Specific Code Generation" + NL + "\t * *********************************" + NL + "\t * This returns ";
  protected final String TEXT_79 = ".gif." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_80 = NL + "\t@Override";
  protected final String TEXT_81 = NL + "\tpublic Object getImage(Object object)" + NL + "\t{" + NL + "\t";
  protected final String TEXT_82 = " " + NL + "\t\tObject rtrnObj = overlayImage(object, getResourceLocator().getImage(\"full/obj16/";
  protected final String TEXT_83 = "\")); " + NL + "\t\t" + NL + "\t\t// In case we can find a trace to an object typed by IQualifedName we might have an alternative image" + NL + "\t\tIQualifiedName qualifiedNameObject = null;" + NL + "\t\tif (object instanceof ATypeInstance) {" + NL + "\t\t\tATypeInstance typeInstance = (ATypeInstance) object;" + NL + "\t\t\tqualifiedNameObject = typeInstance.getType();" + NL + "\t\t} else if (object instanceof StructuralElementInstance) { " + NL + "\t\t\tStructuralElementInstance structuralElementInstance = (StructuralElementInstance) object;" + NL + "\t\t\tqualifiedNameObject = structuralElementInstance.getType();\t\t\t" + NL + "\t\t} else if (object instanceof StructuralElement) { " + NL + "\t\t\tqualifiedNameObject = (StructuralElement) object;\t\t" + NL + "\t\t} else if (object instanceof Category) { " + NL + "\t\t\tqualifiedNameObject = (Category) object;\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t// In case we could trace an object of IQualifedName we now ask the image registry for an alternative image" + NL + "\t\tif (qualifiedNameObject != null) {" + NL + "\t\t\tString fullQualifiedID = qualifiedNameObject.getFullQualifiedName();" + NL + "\t\t\tURL imageUrl = DVLMEditPlugin.getImageRegistry().get(fullQualifiedID);" + NL + "\t\t\tif (imageUrl != null) {" + NL + "\t\t\t\trtrnObj = overlayImage(object, imageUrl);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn rtrnObj;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_84 = NL + "\t\treturn overlayImage(object, getResourceLocator().getImage(\"full/obj16/";
  protected final String TEXT_85 = "\")); ";
  protected final String TEXT_86 = NL + "\t}" + NL + "\t";
  protected final String TEXT_87 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_88 = NL + "\t@Override";
  protected final String TEXT_89 = NL + "\tprotected boolean shouldComposeCreationImage() " + NL + "\t{" + NL + "\t\treturn true;" + NL + "\t}" + NL;
  protected final String TEXT_90 = NL + NL + "\t/**" + NL + "\t * *********************************" + NL + "\t * VirSat Specific Code Generation" + NL + "\t * *********************************" + NL + "\t * This returns the label text for the adapted class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_91 = NL + "\t@Override";
  protected final String TEXT_92 = NL + "\tpublic String getText(Object object)" + NL + "\t{";
  protected final String TEXT_93 = NL;
  protected final String TEXT_94 = NL + "\treturn getString(\"_UI_";
  protected final String TEXT_95 = "_type\");";
  protected final String TEXT_96 = NL + "\t";
  protected final String TEXT_97 = " " + NL + "\t\tString labelName =((";
  protected final String TEXT_98 = ")object).getName();";
  protected final String TEXT_99 = NL + "\t\tString label =((";
  protected final String TEXT_100 = ")object).";
  protected final String TEXT_101 = "();" + NL + "\t\treturn labelName + \": \" + label;";
  protected final String TEXT_102 = " " + NL + "\t";
  protected final String TEXT_103 = "\t" + NL + "\t";
  protected final String TEXT_104 = " " + NL + "\t\tString labelName =((";
  protected final String TEXT_105 = ")object).getName();";
  protected final String TEXT_106 = NL + "\t\tString label =((";
  protected final String TEXT_107 = ")object).";
  protected final String TEXT_108 = "();" + NL + "\t\treturn labelName + \": \" + label;";
  protected final String TEXT_109 = " " + NL + "\t";
  protected final String TEXT_110 = "\t" + NL + "\t";
  protected final String TEXT_111 = NL + "\t\t\treturn ((";
  protected final String TEXT_112 = ")getStyledText(object)).getString();" + NL + "\t";
  protected final String TEXT_113 = NL + "\t";
  protected final String TEXT_114 = NL + "\t\t\t";
  protected final String TEXT_115 = "<?, ?>";
  protected final String TEXT_116 = " ";
  protected final String TEXT_117 = " = (";
  protected final String TEXT_118 = "<?, ?>";
  protected final String TEXT_119 = ")object;" + NL + "  \t";
  protected final String TEXT_120 = NL + "\t\t\treturn \"\" + ";
  protected final String TEXT_121 = ".getKey() + \" -> \" + ";
  protected final String TEXT_122 = ".getValue();";
  protected final String TEXT_123 = NL + "  \t";
  protected final String TEXT_124 = NL + "    \t";
  protected final String TEXT_125 = NL + "\t\t\tString key = crop(\"\" + ";
  protected final String TEXT_126 = ".getKey());";
  protected final String TEXT_127 = NL + "    \t";
  protected final String TEXT_128 = NL + "\t\t\tString key = \"\" + ";
  protected final String TEXT_129 = ".getKey();";
  protected final String TEXT_130 = NL + "    \t";
  protected final String TEXT_131 = NL + "    \t";
  protected final String TEXT_132 = NL + "\t\t\tString value = crop(\"\" + ";
  protected final String TEXT_133 = ".getValue());";
  protected final String TEXT_134 = NL + "    \t";
  protected final String TEXT_135 = NL + "\t\t\tString value = \"\" + ";
  protected final String TEXT_136 = ".getValue();";
  protected final String TEXT_137 = NL + "    \t";
  protected final String TEXT_138 = NL + "\t\t\treturn key + \" -> \" + value;";
  protected final String TEXT_139 = NL + "  \t" + NL + "  \t";
  protected final String TEXT_140 = NL + "\t";
  protected final String TEXT_141 = NL + "  \t";
  protected final String TEXT_142 = NL + "\t\t\t";
  protected final String TEXT_143 = " ";
  protected final String TEXT_144 = " = (";
  protected final String TEXT_145 = ")object;" + NL + "\t\t\treturn getString(\"_UI_";
  protected final String TEXT_146 = "_type\") + \" \" + ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = "();";
  protected final String TEXT_149 = NL + "  \t";
  protected final String TEXT_150 = NL + "    \t";
  protected final String TEXT_151 = NL + "      \t";
  protected final String TEXT_152 = NL + "\t\t\tString label = crop(((";
  protected final String TEXT_153 = ")object).";
  protected final String TEXT_154 = "());" + NL + "      \t";
  protected final String TEXT_155 = NL + "\t\t\tString label = ((";
  protected final String TEXT_156 = ")object).";
  protected final String TEXT_157 = "();" + NL + "      \t";
  protected final String TEXT_158 = NL + "    \t";
  protected final String TEXT_159 = NL + "      \t";
  protected final String TEXT_160 = NL + "\t\t\t";
  protected final String TEXT_161 = " labelValue = ((";
  protected final String TEXT_162 = ")object).eGet(";
  protected final String TEXT_163 = ");" + NL + "      \t";
  protected final String TEXT_164 = NL + "\t\t\t";
  protected final String TEXT_165 = " labelValue = ((";
  protected final String TEXT_166 = ")object).";
  protected final String TEXT_167 = "();" + NL + "      \t";
  protected final String TEXT_168 = NL + "\t\t\tString label = labelValue == null ? null : labelValue.toString();" + NL + "    \t";
  protected final String TEXT_169 = NL + "\t\t\treturn label == null || label.length() == 0 ?" + NL + "\t\t\t\tgetString(\"_UI_";
  protected final String TEXT_170 = "_type\") :";
  protected final String TEXT_171 = NL + "\t\t\t\tgetString(\"_UI_";
  protected final String TEXT_172 = "_type\") + \" \" + label;";
  protected final String TEXT_173 = NL + "  \t";
  protected final String TEXT_174 = NL + "\t";
  protected final String TEXT_175 = NL + "\t\t\treturn getString(\"_UI_";
  protected final String TEXT_176 = "_type\");";
  protected final String TEXT_177 = NL + "\t";
  protected final String TEXT_178 = NL + "\t}" + NL + "\t";
  protected final String TEXT_179 = NL + "\t/**" + NL + "\t * This returns the label styled text for the adapted class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_180 = NL + "\t@Override";
  protected final String TEXT_181 = NL + "\tpublic Object getStyledText(Object object)" + NL + "\t{";
  protected final String TEXT_182 = NL + "\t\t";
  protected final String TEXT_183 = "<?, ?>";
  protected final String TEXT_184 = " ";
  protected final String TEXT_185 = " = (";
  protected final String TEXT_186 = "<?, ?>";
  protected final String TEXT_187 = ")object;";
  protected final String TEXT_188 = NL + "\t\treturn new ";
  protected final String TEXT_189 = "(\"\" + ";
  protected final String TEXT_190 = ".getKey()).append(\" -> \", ";
  protected final String TEXT_191 = ".QUALIFIER_STYLER).append(\"\" + ";
  protected final String TEXT_192 = ".getValue());";
  protected final String TEXT_193 = NL + "\t\tString key = crop(\"\" + ";
  protected final String TEXT_194 = ".getKey());";
  protected final String TEXT_195 = NL + "\t\tString key = \"\" + ";
  protected final String TEXT_196 = ".getKey();";
  protected final String TEXT_197 = NL + "\t\tString value = crop(\"\" + ";
  protected final String TEXT_198 = ".getValue());";
  protected final String TEXT_199 = NL + "\t\tString value = \"\" + ";
  protected final String TEXT_200 = ".getValue();";
  protected final String TEXT_201 = NL + "\t\treturn new ";
  protected final String TEXT_202 = "(key).append(\" -> \", ";
  protected final String TEXT_203 = ".QUALIFIER_STYLER).append(value);";
  protected final String TEXT_204 = NL + "\t\t";
  protected final String TEXT_205 = " ";
  protected final String TEXT_206 = " = (";
  protected final String TEXT_207 = ")object;" + NL + "\t\treturn new ";
  protected final String TEXT_208 = "(getString(\"_UI_";
  protected final String TEXT_209 = "_type\"), ";
  protected final String TEXT_210 = ".QUALIFIER_STYLER).append(\" \").append(";
  protected final String TEXT_211 = ".toString(";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = "()));";
  protected final String TEXT_214 = NL + "\t\tString label = crop(((";
  protected final String TEXT_215 = ")object).";
  protected final String TEXT_216 = "());";
  protected final String TEXT_217 = NL + "\t\tString label = ((";
  protected final String TEXT_218 = ")object).";
  protected final String TEXT_219 = "();";
  protected final String TEXT_220 = NL + "\t\t";
  protected final String TEXT_221 = " labelValue = ((";
  protected final String TEXT_222 = ")object).eGet(";
  protected final String TEXT_223 = ");";
  protected final String TEXT_224 = NL + "\t\t";
  protected final String TEXT_225 = " labelValue = ((";
  protected final String TEXT_226 = ")object).";
  protected final String TEXT_227 = "();";
  protected final String TEXT_228 = NL + "\t\tString label = labelValue == null ? null : labelValue.toString();";
  protected final String TEXT_229 = NL + "    \t";
  protected final String TEXT_230 = " styledLabel = new ";
  protected final String TEXT_231 = "();" + NL + "\t\tif (label == null || label.length() == 0) " + NL + "\t\t{" + NL + "\t\t\tstyledLabel.append(getString(\"_UI_";
  protected final String TEXT_232 = "_type\"), ";
  protected final String TEXT_233 = ".QUALIFIER_STYLER); ";
  protected final String TEXT_234 = NL + "\t\t} else {" + NL + "\t\t\tstyledLabel.append(getString(\"_UI_";
  protected final String TEXT_235 = "_type\"), ";
  protected final String TEXT_236 = ".QUALIFIER_STYLER).append(\" \" + label);";
  protected final String TEXT_237 = NL + "\t\t}" + NL + "\t\treturn styledLabel;";
  protected final String TEXT_238 = NL + "\t\treturn new ";
  protected final String TEXT_239 = "(getString(\"_UI_";
  protected final String TEXT_240 = "_type\"));";
  protected final String TEXT_241 = NL + "\t}\t";
  protected final String TEXT_242 = NL + NL + "\t/**" + NL + "\t * This handles model notifications by calling {@link #updateChildren} to update any cached" + NL + "\t * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_243 = NL + "\t@Override";
  protected final String TEXT_244 = NL + "\tpublic void notifyChanged(Notification notification)" + NL + "\t{" + NL + "\t\tupdateChildren(notification);";
  protected final String TEXT_245 = NL + NL + "\t\tswitch (notification.getFeatureID(";
  protected final String TEXT_246 = ".class))" + NL + "\t\t{";
  protected final String TEXT_247 = NL + "\t\t\tcase ";
  protected final String TEXT_248 = ":";
  protected final String TEXT_249 = NL + "\t\t\t\tfireNotifyChanged(new ";
  protected final String TEXT_250 = "(notification, notification.getNotifier(), false, true));" + NL + "\t\t\t\treturn;";
  protected final String TEXT_251 = NL + "\t\t\tcase ";
  protected final String TEXT_252 = ":";
  protected final String TEXT_253 = NL + "\t\t\t\tfireNotifyChanged(new ";
  protected final String TEXT_254 = "(notification, notification.getNotifier(), true, false));" + NL + "\t\t\t\treturn;";
  protected final String TEXT_255 = NL + "\t\t\tcase ";
  protected final String TEXT_256 = ":";
  protected final String TEXT_257 = NL + "\t\t\t\tfireNotifyChanged(new ";
  protected final String TEXT_258 = "(notification, notification.getNotifier(), true, true));" + NL + "\t\t\t\treturn;";
  protected final String TEXT_259 = NL + "\t\t}";
  protected final String TEXT_260 = NL + "\t\tsuper.notifyChanged(notification);" + NL + "\t}" + NL;
  protected final String TEXT_261 = NL + "\t/**" + NL + "\t * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children" + NL + "\t * that can be created under this object." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_262 = NL + "\t@Override";
  protected final String TEXT_263 = NL + "\tprotected void collectNewChildDescriptors(";
  protected final String TEXT_264 = " newChildDescriptors, Object object)" + NL + "\t{" + NL + "\t\tsuper.collectNewChildDescriptors(newChildDescriptors, object);";
  protected final String TEXT_265 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
  protected final String TEXT_266 = "," + NL + "\t\t\t\t ";
  protected final String TEXT_267 = ".createEntry" + NL + "\t\t\t\t\t(";
  protected final String TEXT_268 = ",";
  protected final String TEXT_269 = NL + "\t\t\t\t\t ";
  protected final String TEXT_270 = ".create(";
  protected final String TEXT_271 = "))));";
  protected final String TEXT_272 = NL + "\t\t\t\t\t ";
  protected final String TEXT_273 = ".create";
  protected final String TEXT_274 = "())));";
  protected final String TEXT_275 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
  protected final String TEXT_276 = "," + NL + "\t\t\t\t ";
  protected final String TEXT_277 = ".createEntry" + NL + "\t\t\t\t\t(";
  protected final String TEXT_278 = ",";
  protected final String TEXT_279 = NL + "\t\t\t\t\t ";
  protected final String TEXT_280 = ")));";
  protected final String TEXT_281 = NL + "\t\t\t\t\t ";
  protected final String TEXT_282 = ")));";
  protected final String TEXT_283 = NL + "\t\t\t\t\t ";
  protected final String TEXT_284 = ".createFromString(";
  protected final String TEXT_285 = ", ";
  protected final String TEXT_286 = "))));";
  protected final String TEXT_287 = " // TODO: ensure this is a valid literal value";
  protected final String TEXT_288 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
  protected final String TEXT_289 = ",";
  protected final String TEXT_290 = NL + "\t\t\t\t ";
  protected final String TEXT_291 = ".create(";
  protected final String TEXT_292 = ")));";
  protected final String TEXT_293 = NL + "\t\t\t\t ";
  protected final String TEXT_294 = ".create";
  protected final String TEXT_295 = "()));";
  protected final String TEXT_296 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
  protected final String TEXT_297 = ",";
  protected final String TEXT_298 = NL + "\t\t\t\t ";
  protected final String TEXT_299 = "));";
  protected final String TEXT_300 = NL + "\t\t\t\t ";
  protected final String TEXT_301 = "));";
  protected final String TEXT_302 = NL + "\t\t\t\t ";
  protected final String TEXT_303 = ".createFromString(";
  protected final String TEXT_304 = ", ";
  protected final String TEXT_305 = ")));";
  protected final String TEXT_306 = " // TODO: ensure this is a valid literal value";
  protected final String TEXT_307 = NL + "\t}" + NL + "\t";
  protected final String TEXT_308 = NL + "\t@Override" + NL + "\tprotected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Collection<?> collection) {" + NL + "\t\t// In case that a Type Instance is inherited it will have some Super TIs being set." + NL + "\t\t// Then the command for removing the TI should fail, because the inheritance" + NL + "\t\t// builder would regenerate it anyway" + NL + "\t\tfor (Object obj : collection) {" + NL + "\t\t\tif (obj instanceof ATypeInstance) {" + NL + "\t\t\t\tATypeInstance ti = (ATypeInstance) obj;" + NL + "\t\t\t\tif (!ti.getSuperTis().isEmpty()) {" + NL + "\t\t\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t// In all other cases create the usual command" + NL + "\t\treturn super.createRemoveCommand(domain, owner, feature, collection);" + NL + "\t}";
  protected final String TEXT_309 = NL + "\t" + NL + "\t/**" + NL + "\t * *********************************" + NL + "\t * VirSat Specific Code Generation" + NL + "\t * *********************************" + NL + " \t * Override to the createAddCommand Method" + NL + " \t * <!-- begin-user-doc -->" + NL + " \t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t*/" + NL + "\t@Override" + NL + "\tprotected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,\tCollection<?> collection, int index) {" + NL + "\t\t";
  protected final String TEXT_310 = NL + "\t\t// Override functionality with the undoable ADD Command that performs undo by taking out the collection from the containing list" + NL + "\t\t// rather than reducing the index and assuming the last objects on the list have been added by the current command" + NL + "\t\treturn new UndoableAddCommand(domain, owner, feature, collection, index);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * *********************************" + NL + "\t * VirSat Specific Code Generation" + NL + "\t * *********************************" + NL + " \t * This pipes the command through our RoleManagmentCheckCommand, so we can check directly if a user is allowed to modify" + NL + " \t * <!-- begin-user-doc -->" + NL + " \t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t*/" + NL + "\t@Override" + NL + "\tpublic Command createCommand(Object object, EditingDomain domain, Class<? extends Command> commandClass, CommandParameter commandParameter) {" + NL + "\t\t";
  protected final String TEXT_311 = "\t\t" + NL + "\t\t// For the Repository and StructuralElementInstances we prefer the command for the aplicablefor paradigm" + NL + "\t\t// If the requested command is not valid for the current obejcts an unexecutable command will be handed back instead" + NL + "\t\tDVLMCommandParameterApplicableForCheck commandParameterCheck = new DVLMCommandParameterApplicableForCheck(commandParameter);" + NL + "\t\tif ((commandClass == SetCommand.class)" + NL + "\t\t\t|| (commandClass == CopyCommand.class)" + NL + "\t\t\t|| (commandClass == CreateCopyCommand.class)" + NL + "\t\t\t|| (commandClass == InitializeCopyCommand.class)" + NL + "\t\t\t|| (commandClass == AddCommand.class)" + NL + "\t\t\t|| (commandClass == MoveCommand.class)" + NL + "\t\t\t|| (commandClass == ReplaceCommand.class)" + NL + "\t\t\t|| (commandClass == DragAndDropCommand.class)" + NL + "\t\t\t|| (commandClass == CreateChildCommand.class)) {" + NL + "\t\t\t" + NL + "\t\t\tif (!commandParameterCheck.isValidCommandParameter(commandParameter)) {" + NL + "\t\t\t\treturn new RoleManagementCheckCommand(UnexecutableCommand.INSTANCE, commandParameter);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_312 = "\t\t" + NL + "\t\t// We don't want to allow remove or delete operations on concepts that have been introduced into the model" + NL + "\t\tif ((commandClass == RemoveCommand.class) || (commandClass == DeleteCommand.class)) {" + NL + "\t\t\tAtomicBoolean removeConcept = new AtomicBoolean(false);" + NL + "\t\t\tcommandParameter.getCollection().forEach((collectionObject) -> removeConcept.set(removeConcept.get() | collectionObject instanceof Concept));" + NL + "\t\t\tif (removeConcept.get() || (commandParameter.getValue() instanceof Concept)) {" + NL + "\t\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t} ";
  protected final String TEXT_313 = "\t\t" + NL + "\t\t// Make sure that we do not allow removing items of static arrays." + NL + "\t\t// Only dynamic arrays should change in their size. Static ones are intialized" + NL + "\t\t// once and their size is kept forever." + NL + "\t\tif ((commandClass == RemoveCommand.class) || (commandClass == AddCommand.class)) {" + NL + "\t\t\t" + NL + "\t\t\tEObject eOwner = commandParameter.getEOwner();" + NL + "\t    \tEObject potentialArrayInstance =  null;" + NL + "\t    \t" + NL + "\t    \tif ((eOwner instanceof ComposedPropertyInstance) || (eOwner instanceof ReferencePropertyInstance)) {" + NL + "\t    \t\tpotentialArrayInstance = eOwner.eContainer();" + NL + "\t    \t} else {" + NL + "\t    \t\tpotentialArrayInstance = eOwner;" + NL + "\t    \t}" + NL + "\t    \t" + NL + "\t    \tif (potentialArrayInstance instanceof ArrayInstance) {" + NL + "\t    \t\tArrayInstance arrayInstance = (ArrayInstance) potentialArrayInstance;" + NL + "\t    \t\t" + NL + "\t    \t\tif (arrayInstance.getType() instanceof AProperty) {" + NL + "\t    \t\t\tAProperty property = (AProperty) arrayInstance.getType();" + NL + "\t    \t\t\t" + NL + "\t    \t\t\tif (property.getArrayModifier() instanceof StaticArrayModifier) {" + NL + "\t    \t\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t    \t\t\t}" + NL + "\t    \t\t}" + NL + "\t    \t}\t  " + NL + "\t    }";
  protected final String TEXT_314 = NL + "\t    \t\t" + NL + "\t\t// For all other commands get the original one" + NL + "\t\tCommand originalCommand = super.createCommand(object, domain, commandClass, commandParameter);" + NL + "\t\t";
  protected final String TEXT_315 = NL + "\t\t// In case we try to set the value we also want to make sure that the override attribute gets set" + NL + "\t\tif (commandClass == SetCommand.class && commandParameter.getEAttribute() == PropertyinstancesPackage.Literals.VALUE_PROPERTY_INSTANCE__VALUE) {" + NL + "\t\t\tCommand setOverrideCommand = SetCommand.create(domain, object, InheritancePackage.Literals.IOVERRIDABLE_INHERITANCE_LINK__OVERRIDE, true);" + NL + "\t\t\tCompoundCommand setValueAndOverrideCommand = new CompoundCommand(\"Set Value and Override\");" + NL + "\t\t\tsetValueAndOverrideCommand.append(setOverrideCommand);" + NL + "\t\t\tsetValueAndOverrideCommand.append(originalCommand);" + NL + "\t\t\treturn setValueAndOverrideCommand;" + NL + "\t    }" + NL + "\t    ";
  protected final String TEXT_316 = "\t\t" + NL + "\t    ";
  protected final String TEXT_317 = NL + "\t\t// In case we try to set the value we also want to make sure that the override attribute gets set" + NL + "\t\tif (commandClass == SetCommand.class && commandParameter.getEAttribute() == PropertyinstancesPackage.Literals.RESOURCE_PROPERTY_INSTANCE__RESOURCE_URI) {" + NL + "\t\t\tCommand setOverrideCommand = SetCommand.create(domain, object, InheritancePackage.Literals.IOVERRIDABLE_INHERITANCE_LINK__OVERRIDE, true);" + NL + "\t\t\tCompoundCommand setValueAndOverrideCommand = new CompoundCommand(\"Set Value and Override\");" + NL + "\t\t\tsetValueAndOverrideCommand.append(setOverrideCommand);" + NL + "\t\t\tsetValueAndOverrideCommand.append(originalCommand);" + NL + "\t\t\treturn setValueAndOverrideCommand;" + NL + "\t    }" + NL + "\t    ";
  protected final String TEXT_318 = NL + "\t    ";
  protected final String TEXT_319 = NL + "\t\t// In case we try to set the value we also want to make sure that the override attribute gets set" + NL + "\t\tif (commandClass == SetCommand.class && commandParameter.getEReference() == PropertyinstancesPackage.Literals.REFERENCE_PROPERTY_INSTANCE__REFERENCE) {" + NL + "\t\t\tCommand setOverrideCommand = SetCommand.create(domain, object, InheritancePackage.Literals.IOVERRIDABLE_INHERITANCE_LINK__OVERRIDE, true);" + NL + "\t\t\tCompoundCommand setValueAndOverrideCommand = new CompoundCommand(\"Set Value and Override\");" + NL + "\t\t\tsetValueAndOverrideCommand.append(setOverrideCommand);" + NL + "\t\t\tsetValueAndOverrideCommand.append(originalCommand);" + NL + "\t\t\treturn setValueAndOverrideCommand;" + NL + "\t    }" + NL + "\t    ";
  protected final String TEXT_320 = NL + "\t    ";
  protected final String TEXT_321 = NL + "\t\t// In case we try to set the value we also want to make sure that the override attribute gets set" + NL + "\t\tif (commandClass == SetCommand.class && (commandParameter.getEReference() == PropertyinstancesPackage.Literals.IUNIT_PROPERTY_INSTANCE__UNIT || commandParameter.getEAttribute() == PropertyinstancesPackage.Literals.VALUE_PROPERTY_INSTANCE__VALUE)) {" + NL + "\t\t\tCommand setOverrideCommand = SetCommand.create(domain, object, InheritancePackage.Literals.IOVERRIDABLE_INHERITANCE_LINK__OVERRIDE, true);" + NL + "\t\t\tCompoundCommand setValueAndOverrideCommand = new CompoundCommand(\"Set Value and Override\");" + NL + "\t\t\tsetValueAndOverrideCommand.append(setOverrideCommand);" + NL + "\t\t\tsetValueAndOverrideCommand.append(originalCommand);" + NL + "\t\t\treturn setValueAndOverrideCommand;" + NL + "\t    }" + NL + "\t    ";
  protected final String TEXT_322 = "\t\t" + NL + "\t    ";
  protected final String TEXT_323 = NL + "\t\tif (commandClass == SetCommand.class && commandParameter.getFeature() == GeneralPackage.Literals.INAME__NAME) {" + NL + "\t\t\tCategoryAssignment ca = (CategoryAssignment) object;" + NL + "\t\t\tif (ca.isIsInherited()) {" + NL + "\t\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t    ";
  protected final String TEXT_324 = "\t" + NL + "\t\t// A RolemanagementCheckCommand should not necessarily be wrapped into another RoleManagementCheck Command" + NL + "\t\tif (originalCommand instanceof RoleManagementCheckCommand) {" + NL + "\t\t\treturn originalCommand;" + NL + "\t\t} else {" + NL + "\t\t\t// And wrap it into our command checking for the proper access rights" + NL + "\t\t\treturn new RoleManagementCheckCommand(originalCommand, commandParameter);\t" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_325 = NL + "\t/**" + NL + "\t * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_326 = NL + "\t@Override";
  protected final String TEXT_327 = NL + "\tpublic String getCreateChildText(Object owner, Object feature, Object child, ";
  protected final String TEXT_328 = " selection)" + NL + "\t{" + NL + "\t\tObject childFeature = feature;" + NL + "\t\tObject childObject = child;" + NL;
  protected final String TEXT_329 = NL + "\t\tif (childFeature instanceof ";
  protected final String TEXT_330 = " && ";
  protected final String TEXT_331 = ".isFeatureMap((EStructuralFeature)childFeature))" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_332 = ".Entry entry = (FeatureMap.Entry)childObject;" + NL + "\t\t\tchildFeature = entry.getEStructuralFeature();" + NL + "\t\t\tchildObject = entry.getValue();" + NL + "\t\t}" + NL;
  protected final String TEXT_333 = NL + "\t\tboolean qualify =";
  protected final String TEXT_334 = NL + "\t\t\tchildFeature == ";
  protected final String TEXT_335 = NL + NL + "\t\tif (qualify)" + NL + "\t\t{" + NL + "\t\t\treturn getString" + NL + "\t\t\t\t(\"_UI_CreateChild_text2\",";
  protected final String TEXT_336 = NL + "\t\t\t\t new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });" + NL + "\t\t}" + NL + "\t\treturn super.getCreateChildText(owner, feature, child, selection);" + NL + "\t}" + NL;
  protected final String TEXT_337 = NL + "\t/**" + NL + "\t * Return the resource locator for this item provider's resources." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_338 = NL + "\t@Override";
  protected final String TEXT_339 = NL + "\tpublic ";
  protected final String TEXT_340 = " getResourceLocator()" + NL + "\t{";
  protected final String TEXT_341 = NL + "\t\treturn ((";
  protected final String TEXT_342 = ")adapterFactory).getResourceLocator();";
  protected final String TEXT_343 = NL + "\t\treturn ";
  protected final String TEXT_344 = ".INSTANCE;";
  protected final String TEXT_345 = NL + "\t}" + NL;
  protected final String TEXT_346 = NL + "}";
  protected final String TEXT_347 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/**
 * Copyright (c) 2002-2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   DLR - customization for Virtual Satellite
 */

    stringBuffer.append(TEXT_1);
    final String MODEL_CLASS_VALUE_PROPERTY_INSTANCE = "ValuePropertyInstance";
    final String MODEL_CLASS_RESOURCE_PROPERTY_INSTANCE = "ResourcePropertyInstance";
    final String MODEL_CLASS_REFERENCE_PROPERTY_INSTANCE = "ReferencePropertyInstance";
    final String MODEL_CLASS_UNIT_VALUE_PROPERTY_INSTANCE = "UnitValuePropertyInstance";
    final String MODEL_CLASS_A_TYPE_INSTANCE = "ATypeInstance";
    final String MODEL_CLASS_I_CATEGORY_ASSIGNMENT_CONTAINER = "ICategoryAssignmentContainer";
    final String MODEL_CLASS_STRUCTURAL_ELEMENT_INSTANCE = "StructuralElementInstance";
    final String MODEL_CLASS_CATEGORY_ASSIGNMENT = "CategoryAssignment";
    final String MODEL_CLASS_STRUCTURAL_ELEMENT = "StructuralElement";
    final String MODEL_CLASS_CATEGORY = "Category";
    final String MODEL_CLASS_REPOSITORY = "Repository";
    final String MODEL_CLASS_ROLEMANAGEMENT = "RoleManagement";
    final String MODEL_CLASS_UNITMANAGEMENT = "UnitManagement";
    final String MODEL_CLASS_ARRAYINSTANCE = "ArrayInstance";
    final String MODEL_CLASS_AUNIT = "AUnit";
    final String MODEL_CLASS_PREFIX = "Prefix";
    stringBuffer.append(TEXT_2);
    GenClass genClass = (GenClass)argument; GenPackage genPackage = genClass.getGenPackage(); GenModel genModel=genPackage.getGenModel();
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    {GenBase copyrightHolder = argument instanceof GenBase ? (GenBase)argument : argument instanceof Object[] && ((Object[])argument)[0] instanceof GenBase ? (GenBase)((Object[])argument)[0] : null;
    if (copyrightHolder != null && copyrightHolder.hasCopyright()) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(copyrightHolder.getCopyright(copyrightHolder.getGenModel().getIndentation(stringBuffer)));
    }}
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genPackage.getProviderPackageName());
    stringBuffer.append(TEXT_7);
    
/*
 * *********************************
 * VirSat Specific Code Generation
 * *********************************
 * Loop over all Interfaces and Extended Classes to find the one defining ATypeInstance
 * Remember it in case it exists. Information will be used later in the code to resolve a custom image for these classes
 */
boolean isInstanceOfValuePropertyInstance = MODEL_CLASS_VALUE_PROPERTY_INSTANCE.equals(genClass.getName());
boolean isInstanceOfResourcePropertyInstance = MODEL_CLASS_RESOURCE_PROPERTY_INSTANCE.equals(genClass.getName());
boolean isInstanceOfReferencePropertyInstance = MODEL_CLASS_REFERENCE_PROPERTY_INSTANCE.equals(genClass.getName());
boolean isInstanceOfUnitValuePropertyInstance = MODEL_CLASS_UNIT_VALUE_PROPERTY_INSTANCE.equals(genClass.getName());
boolean isInstanceOfATypeInstance = genClass.getAllBaseGenClasses().stream().anyMatch((GenClass predicate) -> MODEL_CLASS_A_TYPE_INSTANCE.equals(predicate.getInterfaceName()));
boolean isInstanceOfICategoryAssignmentContainer = genClass.getAllBaseGenClasses().stream().anyMatch((GenClass predicate) -> MODEL_CLASS_I_CATEGORY_ASSIGNMENT_CONTAINER.equals(predicate.getInterfaceName()));
boolean isInstanceOfStructuralElementInstance = MODEL_CLASS_STRUCTURAL_ELEMENT_INSTANCE.equals(genClass.getName());
boolean isInstanceOfStructuralElement = MODEL_CLASS_STRUCTURAL_ELEMENT.equals(genClass.getName());
boolean isInstanceOfCategory = MODEL_CLASS_CATEGORY.equals(genClass.getName());
boolean isInstanceOfCategoryAssignment = MODEL_CLASS_CATEGORY_ASSIGNMENT.equals(genClass.getName());
boolean isInstanceOfRepository = MODEL_CLASS_REPOSITORY.equals(genClass.getName());
boolean isInstanceOfRoleManagement = MODEL_CLASS_ROLEMANAGEMENT.equals(genClass.getName());
boolean isInstanceOfUnitManagement = MODEL_CLASS_UNITMANAGEMENT.equals(genClass.getName());
boolean isInstanceOfArrayInstance = MODEL_CLASS_ARRAYINSTANCE.equals(genClass.getName());
boolean isInstanceOfAUnit = genClass.getAllBaseGenClasses().stream().anyMatch((GenClass predicate) -> MODEL_CLASS_AUNIT.equals(predicate.getInterfaceName()));
boolean isInstanceOfPrefix = MODEL_CLASS_PREFIX.equals(genClass.getName());

//System.out.println("ClassName: " + String.format("%25s", genClass.getName()) + "  ATypeInstance: " + isInstanceOfATypeInstance + "  Repository: " + isInstanceOfRepository);

    genModel.addImport("org.eclipse.emf.common.notify.AdapterFactory");
    genModel.addImport("org.eclipse.emf.common.notify.Notification");
    genModel.addImport("org.eclipse.emf.common.command.Command");
    genModel.addImport("org.eclipse.emf.edit.command.CommandParameter");
    genModel.addImport("org.eclipse.emf.edit.domain.EditingDomain");
    genModel.addImport("de.dlr.sc.virsat.model.dvlm.roles.RoleManagementCheckCommand");
    stringBuffer.append(TEXT_8);
    String _List = genModel.getImportedName(genModel.useGenerics() ? "java.util.List<org.eclipse.emf.edit.provider.IItemPropertyDescriptor>" : "java.util.List");
    genModel.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genClass.getProviderClassName());
    stringBuffer.append(TEXT_11);
    if (genClass.getProviderImplementsClassNames().isEmpty()) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genClass.getProviderBaseClassName() != null ? genClass.getProviderBaseClassName() : genModel.getImportedName("org.eclipse.emf.edit.provider.ItemProviderAdapter"));
    }
    if (!genClass.getProviderImplementsClassNames().isEmpty()) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genClass.getProviderBaseClassName() != null ? genClass.getProviderBaseClassName() : genModel.getImportedName("org.eclipse.emf.edit.provider.ItemProviderAdapter"));
    stringBuffer.append(TEXT_14);
    for (Iterator<String> i = genClass.getProviderImplementsClassNames().iterator(); i.hasNext(); ) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genModel.getImportedName(i.next()));
    if (i.hasNext()){
    stringBuffer.append(TEXT_16);
    }
    }
    }
    stringBuffer.append(TEXT_17);
    if (genModel.hasCopyrightField()) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genModel.getCopyrightFieldLiteral());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genClass.getProviderClassName());
    stringBuffer.append(TEXT_23);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(_List);
    stringBuffer.append(TEXT_26);
    for (GenFeature genFeature : genClass.getPropertyFeatures()) { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    for (GenFeature genFeature : genClass.getPropertyFeatures()) { 
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ComposeableAdapterFactory"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genFeature.getGenClass().getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genModel.getNonNLS());
    if (genFeature.getPropertyDescription() == null || genFeature.getPropertyDescription().length() == 0) {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genFeature.getGenClass().getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genFeature.getGenClass().getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(genModel.getNonNLS(3));
    } else {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genFeature.getGenClass().getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genModel.getNonNLS());
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genFeature.getProperty() == GenPropertyKind.EDITABLE_LITERAL ? "true" : "false");
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genFeature.isPropertyMultiLine() ? "true" : "false");
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genFeature.isPropertySortChoices() ? "true" : "false");
    stringBuffer.append(TEXT_48);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_49);
    } else {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ItemPropertyDescriptor"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genFeature.getPropertyImageName());
    stringBuffer.append(TEXT_52);
    }
    if (genFeature.getPropertyCategory() == null || genFeature.getPropertyCategory().length() == 0) {
    stringBuffer.append(TEXT_53);
    } else {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genModel.getPropertyCategoryKey(genFeature.getPropertyCategory()));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(genModel.getNonNLS());
    }
    if (genFeature.getPropertyFilterFlags().isEmpty()) {
    stringBuffer.append(TEXT_56);
    } else {
    stringBuffer.append(TEXT_57);
    for (Iterator<String> j = genFeature.getPropertyFilterFlags().iterator(); j.hasNext();) { String filterFlag = j.next();
    if (filterFlag != null && filterFlag.length() > 0) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(filterFlag);
    stringBuffer.append(TEXT_59);
    if (j.hasNext()) {
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(genModel.getNonNLS());
    }
    }
    stringBuffer.append(TEXT_61);
    }
    //ItemProvider/addPropertyDescriptor.override.javajetinc
    stringBuffer.append(TEXT_62);
    }
    if (!genClass.getChildrenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_63);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genModel.getImportedName(genModel.useGenerics() ? "java.util.Collection<? extends org.eclipse.emf.ecore.EStructuralFeature>" : "java.util.Collection"));
    stringBuffer.append(TEXT_66);
    for (GenFeature genFeature : genClass.getChildrenFeatures()) { 
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    if (!genClass.getChildrenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_70);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_73);
    }
    }
    if (genClass.needsHasChildrenMethodOverride()) {
    stringBuffer.append(TEXT_74);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(genModel.isOptimizedHasChildren());
    stringBuffer.append(TEXT_77);
    }
    if (genClass.isImage()) {
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_79);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    if (isInstanceOfATypeInstance | isInstanceOfStructuralElementInstance | isInstanceOfStructuralElement | isInstanceOfCategory) {
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.provider.DVLMEditPlugin");
		genModel.getImportedName("java.net.URL");
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.categories.ATypeInstance");
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.general.IQualifiedName");
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.structural.StructuralElement");
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.categories.Category");
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.structural.StructuralElementInstance");
    stringBuffer.append(TEXT_82);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_83);
    } else {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_86);
    }
    }
    if (genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF26_VALUE && !genModel.isCreationIcons()) {
    stringBuffer.append(TEXT_87);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    if (isInstanceOfRepository | isInstanceOfRoleManagement | isInstanceOfUnitManagement) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genModel.getNonNLS());
    } 
     else {
    stringBuffer.append(TEXT_96);
    if (isInstanceOfAUnit) {
    stringBuffer.append(TEXT_97);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(genClass.getLabelFeature().getGetAccessor());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_102);
    }
	else {
    stringBuffer.append(TEXT_103);
    if (isInstanceOfPrefix) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(genClass.getLabelFeature().getGetAccessor());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_109);
    }
	else {
    stringBuffer.append(TEXT_110);
    if (genModel.isStyleProviders()) {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
    stringBuffer.append(TEXT_112);
    } else {
    stringBuffer.append(TEXT_113);
    if (genClass.isMapEntry()) {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(genClass.getImportedInterfaceName());
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(genClass.getImportedInterfaceName());
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    if (!genClass.getMapEntryKeyFeature().isPropertyMultiLine() && !genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
    stringBuffer.append(TEXT_120);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_123);
    } else {
    stringBuffer.append(TEXT_124);
    if (genClass.getMapEntryKeyFeature().isPropertyMultiLine()) {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_127);
    } else {
    stringBuffer.append(TEXT_128);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    if (genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
    stringBuffer.append(TEXT_132);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_134);
    } else {
    stringBuffer.append(TEXT_135);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    } else if (genClass.getLabelFeature() != null) { GenFeature labelFeature = genClass.getLabelFeature();
    stringBuffer.append(TEXT_141);
    if (labelFeature.isPrimitiveType() && !labelFeature.getGenClass().isDynamic() && !labelFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(genClass.getLabelFeature().getGetAccessor());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_149);
    } else {
    stringBuffer.append(TEXT_150);
    if (labelFeature.isStringType() && !labelFeature.getGenClass().isDynamic() && !labelFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_151);
    if (labelFeature.isPropertyMultiLine()) {
    stringBuffer.append(TEXT_152);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(labelFeature.getGetAccessor());
    stringBuffer.append(TEXT_154);
    } else {
    stringBuffer.append(TEXT_155);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(labelFeature.getGetAccessor());
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    } else {
    stringBuffer.append(TEXT_159);
    if (labelFeature.isSuppressedGetVisibility() || labelFeature.getGenClass().isDynamic()) {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(genModel.getImportedName("java.lang.Object"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(labelFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_163);
    } else {
    stringBuffer.append(TEXT_164);
    stringBuffer.append(labelFeature.getRawImportedType());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(labelFeature.getGetAccessor());
    stringBuffer.append(TEXT_167);
    }
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_171);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    } else {
    stringBuffer.append(TEXT_175);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_177);
    }
    }
    }
    }
    }
    //ItemProvider/getText.override.javajetinc
    stringBuffer.append(TEXT_178);
    if (genModel.isStyleProviders()) {
    stringBuffer.append(TEXT_179);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_180);
    }
    stringBuffer.append(TEXT_181);
    if (genClass.isMapEntry()) {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(genClass.getImportedInterfaceName());
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_185);
    stringBuffer.append(genClass.getImportedInterfaceName());
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    if (!genClass.getMapEntryKeyFeature().isPropertyMultiLine() && !genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
    stringBuffer.append(TEXT_188);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    } else {
    if (genClass.getMapEntryKeyFeature().isPropertyMultiLine()) {
    stringBuffer.append(TEXT_193);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_195);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(genModel.getNonNLS());
    }
    if (genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
    stringBuffer.append(TEXT_197);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_198);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_199);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(genModel.getNonNLS());
    }
    stringBuffer.append(TEXT_201);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(genModel.getNonNLS());
    }
    } else if (genClass.getLabelFeature() != null) { GenFeature labelFeature = genClass.getLabelFeature();
    if (labelFeature.isPrimitiveType() && !labelFeature.getGenClass().isDynamic() && !labelFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_204);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_206);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_207);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(labelFeature.getObjectType(genClass));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(genClass.getLabelFeature().getGetAccessor());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    } else {
    if (labelFeature.isStringType() && !labelFeature.getGenClass().isDynamic() && !labelFeature.isSuppressedGetVisibility()) {
    if (labelFeature.isPropertyMultiLine()) {
    stringBuffer.append(TEXT_214);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_215);
    stringBuffer.append(labelFeature.getGetAccessor());
    stringBuffer.append(TEXT_216);
    } else {
    stringBuffer.append(TEXT_217);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(labelFeature.getGetAccessor());
    stringBuffer.append(TEXT_219);
    }
    } else {
    if (labelFeature.isSuppressedGetVisibility() || labelFeature.getGenClass().isDynamic()) {
    stringBuffer.append(TEXT_220);
    stringBuffer.append(genModel.getImportedName("java.lang.Object"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(labelFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_223);
    } else {
    stringBuffer.append(TEXT_224);
    stringBuffer.append(labelFeature.getRawImportedType());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_226);
    stringBuffer.append(labelFeature.getGetAccessor());
    stringBuffer.append(TEXT_227);
    }
    stringBuffer.append(TEXT_228);
    }
    stringBuffer.append(TEXT_229);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_234);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_235);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_237);
    }
    } else {
    stringBuffer.append(TEXT_238);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(genModel.getNonNLS());
    }
    //ItemProvider/getStyledText.override.javajetinc
    stringBuffer.append(TEXT_241);
    }
    stringBuffer.append(TEXT_242);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_243);
    }
    stringBuffer.append(TEXT_244);
    if (!genClass.getLabelNotifyFeatures().isEmpty() || !genClass.getContentNotifyFeatures().isEmpty() || !genClass.getLabelAndContentNotifyFeatures().isEmpty()) {
    stringBuffer.append(TEXT_245);
    stringBuffer.append(genClass.getRawImportedInterfaceName());
    stringBuffer.append(TEXT_246);
    if (!genClass.getLabelNotifyFeatures().isEmpty()) {
    for (GenFeature genFeature : genClass.getLabelNotifyFeatures()) { 
    stringBuffer.append(TEXT_247);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_248);
    }
    stringBuffer.append(TEXT_249);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
    stringBuffer.append(TEXT_250);
    }
    if (!genClass.getContentNotifyFeatures().isEmpty()) {
    for (GenFeature genFeature : genClass.getContentNotifyFeatures()) { 
    stringBuffer.append(TEXT_251);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_252);
    }
    stringBuffer.append(TEXT_253);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
    stringBuffer.append(TEXT_254);
    }
    if (!genClass.getLabelAndContentNotifyFeatures().isEmpty()) {
    for (GenFeature genFeature : genClass.getLabelAndContentNotifyFeatures()) { 
    stringBuffer.append(TEXT_255);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_256);
    }
    stringBuffer.append(TEXT_257);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
    stringBuffer.append(TEXT_258);
    }
    stringBuffer.append(TEXT_259);
    }
    stringBuffer.append(TEXT_260);
    if (genModel.isCreationCommands()) {
    stringBuffer.append(TEXT_261);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_262);
    }
    stringBuffer.append(TEXT_263);
    stringBuffer.append(genModel.getImportedName(genModel.useGenerics() ? "java.util.Collection<java.lang.Object>" : "java.util.Collection"));
    stringBuffer.append(TEXT_264);
    for (GenClass.ChildCreationData childCreationData : genClass.getChildCreationData()) { GenFeature createFeature = childCreationData.createFeature; GenFeature delegatedFeature = childCreationData.delegatedFeature; GenClassifier createClassifier = childCreationData.createClassifier;
    if (createFeature.isFeatureMapType()) {
    if (delegatedFeature.isReferenceType()) { GenClass createClass = (GenClass)createClassifier;
    stringBuffer.append(TEXT_265);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(delegatedFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_268);
    if (createClass.isMapEntry()) { 
    stringBuffer.append(TEXT_269);
    stringBuffer.append(createClass.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(createClass.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_271);
    } else {
    stringBuffer.append(TEXT_272);
    stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
    stringBuffer.append(TEXT_273);
    stringBuffer.append(createClass.getName());
    stringBuffer.append(TEXT_274);
    }
    //ItemProvider/newChildDescriptorsReferenceDelegatedFeature.override.javajetinc
    } else { GenDataType createDataType = (GenDataType)createClassifier;
    stringBuffer.append(TEXT_275);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_276);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(delegatedFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_278);
    if (delegatedFeature.isEnumBasedType()) {
    stringBuffer.append(TEXT_279);
    stringBuffer.append(delegatedFeature.getTypeGenEnum().getStaticValue(delegatedFeature.getEcoreFeature().getDefaultValueLiteral()));
    stringBuffer.append(TEXT_280);
    } else if (delegatedFeature.isStringBasedType()) {
    stringBuffer.append(TEXT_281);
    stringBuffer.append(delegatedFeature.getCreateChildValueLiteral());
    stringBuffer.append(TEXT_282);
    stringBuffer.append(genModel.getNonNLS());
    } else { String literal = delegatedFeature.getCreateChildValueLiteral();
    stringBuffer.append(TEXT_283);
    stringBuffer.append(createDataType.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(createDataType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_285);
    stringBuffer.append(literal);
    stringBuffer.append(TEXT_286);
    if (literal != null) {
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_287);
    }
    }
    //ItemProvider/newChildDescriptorsAttributeDelegatedFeature.override.javajetinc
    }
    } else if (createFeature.isReferenceType()) { GenClass createClass = (GenClass)createClassifier;
    stringBuffer.append(TEXT_288);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_289);
    if (createClass.isMapEntry()) { 
    stringBuffer.append(TEXT_290);
    stringBuffer.append(createClass.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_291);
    stringBuffer.append(createClass.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_292);
    } else {
    stringBuffer.append(TEXT_293);
    stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
    stringBuffer.append(TEXT_294);
    stringBuffer.append(createClass.getName());
    stringBuffer.append(TEXT_295);
    }
    //ItemProvider/newChildDescriptorsReferenceFeature.override.javajetinc 
    } else { GenDataType createDataType = (GenDataType)createClassifier;
    stringBuffer.append(TEXT_296);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_297);
    if (createFeature.isEnumBasedType()) {
    stringBuffer.append(TEXT_298);
    stringBuffer.append(createFeature.getTypeGenEnum().getStaticValue(createFeature.getEcoreFeature().getDefaultValueLiteral()));
    stringBuffer.append(TEXT_299);
    } else if (createFeature.isStringBasedType()) {
    stringBuffer.append(TEXT_300);
    stringBuffer.append(createFeature.getCreateChildValueLiteral());
    stringBuffer.append(TEXT_301);
    stringBuffer.append(genModel.getNonNLS());
    } else { String literal = createFeature.getCreateChildValueLiteral();
    stringBuffer.append(TEXT_302);
    stringBuffer.append(createDataType.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_303);
    stringBuffer.append(createDataType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_304);
    stringBuffer.append(literal);
    stringBuffer.append(TEXT_305);
    if (literal != null) {
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_306);
    }
    }
    //ItemProvider/newChildDescriptorsAttributeFeature.override.javajetinc
    }
    }
    stringBuffer.append(TEXT_307);
     
	// Here we override the command for removing ATypeinstances
	// This should only happen in the cases where no super TIs are present
	// at the object. In all otehr cases the following method should either
	// not be generated ot refer to the create Comamnd of the super class
	if (isInstanceOfICategoryAssignmentContainer) {
		genModel.getImportedName("org.eclipse.emf.ecore.EObject");
		genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature");
		genModel.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand");	
    stringBuffer.append(TEXT_308);
     } 
    stringBuffer.append(TEXT_309);
    	genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.command.UndoableAddCommand");
			genModel.getImportedName("org.eclipse.emf.ecore.EObject");
			genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature");
			genModel.getImportedName("java.util.Collection");
			genModel.getImportedName("org.eclipse.emf.edit.domain.EditingDomain");
    stringBuffer.append(TEXT_310);
    if (isInstanceOfRepository || isInstanceOfStructuralElementInstance) {
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.util.DVLMCommandParameterApplicableForCheck");
		genModel.getImportedName("org.eclipse.emf.edit.command.AddCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.CommandParameter");
		genModel.getImportedName("org.eclipse.emf.edit.command.CopyCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.CreateChildCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.CreateCopyCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.DragAndDropCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.InitializeCopyCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.MoveCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.ReplaceCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.SetCommand");
		genModel.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand");
    stringBuffer.append(TEXT_311);
    }
		if (isInstanceOfRepository) {
		// In case we create some commands on the repository we want that 
		// they will be forwarded into an unexecutable command. E.G we expect such
		// a behaviour for removing already active concepts. Such a command should
		// not be executable.		
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.concepts.Concept");
		genModel.getImportedName("java.util.concurrent.atomic.AtomicBoolean");
		genModel.getImportedName("org.eclipse.emf.edit.command.DeleteCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.RemoveCommand");
		genModel.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand");
    stringBuffer.append(TEXT_312);
    } else if (isInstanceOfArrayInstance) {
		// Arrays are specific as well. Only dynamic arrays should allow to remove
		// or delete items of them. Static arrays should never be changed
		// once they are initialized.
		genModel.getImportedName("org.eclipse.emf.ecore.EObject");
		genModel.getImportedName("org.eclipse.emf.edit.command.RemoveCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.AddCommand");
		genModel.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand");
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.categories.propertyinstances.ComposedPropertyInstance");
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.categories.propertyinstances.ReferencePropertyInstance");
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.categories.propertyinstances.command.ArrayInstance");
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.categories.propertydefinitions.AProperty");
		genModel.getImportedName("de.dlr.sc.virsat.model.dvlm.categories.propertydefinitions.StaticArrayModifier"); 
    stringBuffer.append(TEXT_313);
    }
    stringBuffer.append(TEXT_314);
    if (isInstanceOfValuePropertyInstance) {
		// Incase we are accessing the set value method of a derived data item
		// we want to have the override status being set, otherwise, the inehritance builder
		// will directly change back the changes that ahve been set with the setvalue method
		genModel.getImportedName("org.eclipse.emf.common.command.CompoundCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.SetCommand"); 
    stringBuffer.append(TEXT_315);
    }
    stringBuffer.append(TEXT_316);
    if (isInstanceOfResourcePropertyInstance) {
		// Incase we are accessing the set value method of a derived data item
		// we want to have the override status being set, otherwise, the inehritance builder
		// will directly change back the changes that ahve been set with the setvalue method
		genModel.getImportedName("org.eclipse.emf.common.command.CompoundCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.SetCommand"); 
    stringBuffer.append(TEXT_317);
    }
    stringBuffer.append(TEXT_318);
    if (isInstanceOfReferencePropertyInstance) {
		// Incase we are accessing the set value method of a derived data item
		// we want to have the override status being set, otherwise, the inehritance builder
		// will directly change back the changes that ahve been set with the setvalue method
		genModel.getImportedName("org.eclipse.emf.common.command.CompoundCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.SetCommand"); 
    stringBuffer.append(TEXT_319);
    }
    stringBuffer.append(TEXT_320);
    if (isInstanceOfUnitValuePropertyInstance) {
		// Incase we are accessing the set value method of a derived data item
		// we want to have the override status being set, otherwise, the inehritance builder
		// will directly change back the changes that have been set with the setvalue method
		genModel.getImportedName("org.eclipse.emf.common.command.CompoundCommand");
		genModel.getImportedName("org.eclipse.emf.edit.command.SetCommand"); 
    stringBuffer.append(TEXT_321);
    }
    stringBuffer.append(TEXT_322);
    if (isInstanceOfCategoryAssignment) {
		// Incase we are accessing the set value method of a category assignment
		// We need to check if it has been inherited and if that is the case
		// We disallow changing the name via the set method
		genModel.getImportedName("org.eclipse.emf.edit.command.SetCommand"); 
		genModel.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"); 
    stringBuffer.append(TEXT_323);
    }
    stringBuffer.append(TEXT_324);
    if (!genClass.getSharedClassCreateChildFeatures().isEmpty()) {
    stringBuffer.append(TEXT_325);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_326);
    }
    stringBuffer.append(TEXT_327);
    stringBuffer.append(genModel.getImportedName(genModel.useGenerics() ? "java.util.Collection<?>" : "java.util.Collection"));
    stringBuffer.append(TEXT_328);
    if (genClass.hasFeatureMapCreateChildFeatures()) {
    stringBuffer.append(TEXT_329);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_332);
    }
    stringBuffer.append(TEXT_333);
    for (Iterator<GenFeature> i = genClass.getSharedClassCreateChildFeatures().iterator(); i.hasNext();) { GenFeature createFeature = i.next();
    stringBuffer.append(TEXT_334);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(i.hasNext() ? " ||" : ";");
    }
    stringBuffer.append(TEXT_335);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_336);
    }
    }
    if (genClass.getProviderExtendsGenClass() == null || genClass.getProviderExtendsGenClass().getGenPackage() != genPackage && (!genPackage.isExtensibleProviderFactory() || genClass.getProviderExtendsGenClass().getGenPackage().isExtensibleProviderFactory() != genPackage.isExtensibleProviderFactory())) {
    stringBuffer.append(TEXT_337);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_338);
    }
    stringBuffer.append(TEXT_339);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.ResourceLocator"));
    stringBuffer.append(TEXT_340);
    if (genPackage.isExtensibleProviderFactory()) {
    stringBuffer.append(TEXT_341);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.IChildCreationExtender"));
    stringBuffer.append(TEXT_342);
    } else {
    stringBuffer.append(TEXT_343);
    stringBuffer.append(genPackage.getImportedEditPluginClassName());
    stringBuffer.append(TEXT_344);
    }
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_346);
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_347);
    return stringBuffer.toString();
  }
}
