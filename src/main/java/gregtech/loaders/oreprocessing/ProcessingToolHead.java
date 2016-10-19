package gregtech.loaders.oreprocessing;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.common.GT_Proxy;
import gregtech.common.items.GT_MetaGenerated_Tool_01;
import net.minecraft.item.ItemStack;

public class ProcessingToolHead implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingToolHead() {
        OrePrefixes.toolHeadArrow.add(this);
        OrePrefixes.toolHeadAxe.add(this);
        OrePrefixes.toolHeadBuzzSaw.add(this);
        OrePrefixes.toolHeadChainsaw.add(this);
        OrePrefixes.toolHeadDrill.add(this);
        OrePrefixes.toolHeadFile.add(this);
        OrePrefixes.toolHeadHoe.add(this);
        OrePrefixes.toolHeadPickaxe.add(this);
        OrePrefixes.toolHeadPlow.add(this);
        OrePrefixes.toolHeadSaw.add(this);
        OrePrefixes.toolHeadSense.add(this);
        OrePrefixes.toolHeadShovel.add(this);
        OrePrefixes.toolHeadSword.add(this);
        OrePrefixes.toolHeadUniversalSpade.add(this);
        OrePrefixes.toolHeadWrench.add(this);
        OrePrefixes.toolHeadHammer.add(this);
        OrePrefixes.turbineBlade.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        boolean aSpecialRecipeReq1 = aMaterial.mUnificatable && (aMaterial.mMaterialInto == aMaterial) && !aMaterial.contains(SubTag.NO_SMASHING);
        boolean aSpecialRecipeReq2 = aMaterial.mUnificatable && (aMaterial.mMaterialInto == aMaterial) && !aMaterial.contains(SubTag.NO_WORKING);
        boolean aNoWorking = aMaterial.contains(SubTag.NO_WORKING);
        switch (aPrefix) {
            case toolHeadArrow:
                if (aMaterial.mStandardMoltenFluid != null)
                    GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Arrow.get(0L, new Object[0]), aMaterial.getMolten(36L), GT_Utility.copyAmount(1L, new Object[]{aStack}), 16, 4);
                if (aSpecialRecipeReq2) {
                    GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadArrow, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"Xf", 'X', OrePrefixes.gemChipped.get(aMaterial)});
                    GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadArrow, aMaterial, 3L), GT_Proxy.tBits, new Object[]{(aMaterial.contains(SubTag.WOOD) ? 115 : 'x') + "Pf", 'P', OrePrefixes.plate.get(aMaterial)});
                }
                break;
            case toolHeadAxe:
                GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(6, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                if (aSpecialRecipeReq1) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"PIh", "P  ", "f  ", 'P', OrePrefixes.plate.get(aMaterial), 'I', OrePrefixes.ingot.get(aMaterial)});
                if (!aNoWorking) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"GG ", "G  ", "f  ", 'G', OrePrefixes.gem.get(aMaterial)});
                break;
            case toolHeadBuzzSaw:
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(140, 1, aMaterial, Materials.StainlessSteel, new long[]{100000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PBM", "dXG", "SGP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(140, 1, aMaterial, Materials.StainlessSteel, new long[]{75000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PBM", "dXG", "SGP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(140, 1, aMaterial, Materials.StainlessSteel, new long[]{50000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PBM", "dXG", "SGP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Sodium.get(1L, new Object[0])});
                if (aSpecialRecipeReq2) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadBuzzSaw, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"wXh", "X X", "fXx", 'X', OrePrefixes.plate.get(aMaterial)});
                break;
            case toolHeadChainsaw:
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(110, 1, aMaterial, Materials.StainlessSteel, new long[]{100000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(112, 1, aMaterial, Materials.Titanium, new long[]{400000L, 128L, 2L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_MV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'B', ItemList.Battery_RE_MV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(114, 1, aMaterial, Materials.TungstenSteel, new long[]{1600000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'B', ItemList.Battery_RE_HV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(110, 1, aMaterial, Materials.StainlessSteel, new long[]{75000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(112, 1, aMaterial, Materials.Titanium, new long[]{300000L, 128L, 2L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_MV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'B', ItemList.Battery_RE_MV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(114, 1, aMaterial, Materials.TungstenSteel, new long[]{1200000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'B', ItemList.Battery_RE_HV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(110, 1, aMaterial, Materials.StainlessSteel, new long[]{50000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Sodium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(112, 1, aMaterial, Materials.Titanium, new long[]{200000L, 128L, 2L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_MV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'B', ItemList.Battery_RE_MV_Sodium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(114, 1, aMaterial, Materials.TungstenSteel, new long[]{800000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'B', ItemList.Battery_RE_HV_Sodium.get(1L, new Object[0])});
                if (aSpecialRecipeReq2) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadChainsaw, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"SRS", "XhX", "SRS", 'X', OrePrefixes.plate.get(aMaterial), 'S', OrePrefixes.plate.get(Materials.Steel), 'R', OrePrefixes.ring.get(Materials.Steel)});
                break;
            case toolHeadDrill:
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(100, 1, aMaterial, Materials.StainlessSteel, new long[]{100000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(100, 1, aMaterial, Materials.StainlessSteel, new long[]{75000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(100, 1, aMaterial, Materials.StainlessSteel, new long[]{50000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Sodium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(102, 1, aMaterial, Materials.Titanium, new long[]{400000L, 128L, 2L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_MV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'B', ItemList.Battery_RE_MV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(102, 1, aMaterial, Materials.Titanium, new long[]{300000L, 128L, 2L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_MV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'B', ItemList.Battery_RE_MV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(102, 1, aMaterial, Materials.Titanium, new long[]{200000L, 128L, 2L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_MV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'B', ItemList.Battery_RE_MV_Sodium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(104, 1, aMaterial, Materials.TungstenSteel, new long[]{1600000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'B', ItemList.Battery_RE_HV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(104, 1, aMaterial, Materials.TungstenSteel, new long[]{1200000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'B', ItemList.Battery_RE_HV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(104, 1, aMaterial, Materials.TungstenSteel, new long[]{800000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'B', ItemList.Battery_RE_HV_Sodium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(130, 1, aMaterial, Materials.Titanium, new long[]{1600000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "PRP", "MPB", 'X', OrePrefixes.stickLong.get(aMaterial), 'M', ItemList.Electric_Piston_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'R', OrePrefixes.spring.get(Materials.Titanium), 'B', ItemList.Battery_RE_HV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(130, 1, aMaterial, Materials.Titanium, new long[]{1200000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "PRP", "MPB", 'X', OrePrefixes.stickLong.get(aMaterial), 'M', ItemList.Electric_Piston_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'R', OrePrefixes.spring.get(Materials.Titanium), 'B', ItemList.Battery_RE_HV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(130, 1, aMaterial, Materials.Titanium, new long[]{800000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "PRP", "MPB", 'X', OrePrefixes.stickLong.get(aMaterial), 'M', ItemList.Electric_Piston_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'R', OrePrefixes.spring.get(Materials.Titanium), 'B', ItemList.Battery_RE_HV_Sodium.get(1L, new Object[0])});
                if (aSpecialRecipeReq2) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadDrill, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"XSX", "XSX", "ShS", 'X', OrePrefixes.plate.get(aMaterial), 'S', OrePrefixes.plate.get(Materials.Steel)});
                break;
            case toolHeadFile:
                GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(18, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                if ((!aMaterial.contains(SubTag.NO_SMASHING)) && (!aMaterial.contains(SubTag.BOUNCY))) {
                    GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(18, 1, aMaterial, aMaterial.mHandleMaterial, null), GT_ModHandler.RecipeBits.MIRRORED | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"P", "P", "S", 'P', OrePrefixes.plate.get(aMaterial), 'S', OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                }
                break;
            case toolHeadHoe:
                GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(8, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                if (aSpecialRecipeReq1) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"PIh", "f  ", 'P', OrePrefixes.plate.get(aMaterial), 'I', OrePrefixes.ingot.get(aMaterial)});
                if (!aNoWorking) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"GG ", "f  ", "   ", 'G', OrePrefixes.gem.get(aMaterial)});
                break;
            case toolHeadPickaxe:
                GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(2, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                if (aSpecialRecipeReq1) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"PII", "f h", 'P', OrePrefixes.plate.get(aMaterial), 'I', OrePrefixes.ingot.get(aMaterial)});
                if (!aNoWorking) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"GGG", "f  ", 'G', OrePrefixes.gem.get(aMaterial)});
                break;
            case toolHeadPlow:
                GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(42, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                if (aSpecialRecipeReq1) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadPlow, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"PP", "PP", "hf", 'P', OrePrefixes.plate.get(aMaterial)});
                if (!aNoWorking) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadPlow, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"GG", "GG", " f", 'G', OrePrefixes.gem.get(aMaterial)});
                break;
            case toolHeadSaw:
                GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(10, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                if (aSpecialRecipeReq1) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSaw, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"PP ", "fh ", 'P', OrePrefixes.plate.get(aMaterial), 'I', OrePrefixes.ingot.get(aMaterial)});
                if (!aNoWorking) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSaw, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"GGf", 'G', OrePrefixes.gem.get(aMaterial)});
                break;
            case toolHeadSense:
                GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(40, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                if (aSpecialRecipeReq1) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSense, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"PPI", "hf ", 'P', OrePrefixes.plate.get(aMaterial), 'I', OrePrefixes.ingot.get(aMaterial)});
                if (!aNoWorking) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSense, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"GGG", " f ", "   ", 'G', OrePrefixes.gem.get(aMaterial)});
                break;
            case toolHeadShovel:
                GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(4, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                if (aSpecialRecipeReq1) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadShovel, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"fPh", 'P', OrePrefixes.plate.get(aMaterial), 'I', OrePrefixes.ingot.get(aMaterial)});
                if (!aNoWorking) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadShovel, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"fG", 'G', OrePrefixes.gem.get(aMaterial)});
                break;
            case toolHeadSword:
                GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(0, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                if (aSpecialRecipeReq1) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSword, aMaterial, 1L), GT_Proxy.tBits, new Object[]{" P ", "fPh", 'P', OrePrefixes.plate.get(aMaterial), 'I', OrePrefixes.ingot.get(aMaterial)});
                if (!aNoWorking) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSword, aMaterial, 1L), GT_Proxy.tBits, new Object[]{" G", "fG", 'G', OrePrefixes.gem.get(aMaterial)});
                break;
            case toolHeadUniversalSpade:
                GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(32, 1, aMaterial, aMaterial, null), new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial), OrePrefixes.screw.get(aMaterial), ToolDictNames.craftingToolScrewdriver});
                if (aSpecialRecipeReq2) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadUniversalSpade, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"fX", 'X', OrePrefixes.toolHeadShovel.get(aMaterial)});
                break;
            case toolHeadWrench:
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(120, 1, aMaterial, Materials.StainlessSteel, new long[]{100000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(122, 1, aMaterial, Materials.Titanium, new long[]{400000L, 128L, 2L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_MV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'B', ItemList.Battery_RE_MV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(124, 1, aMaterial, Materials.TungstenSteel, new long[]{1600000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'B', ItemList.Battery_RE_HV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(120, 1, aMaterial, Materials.StainlessSteel, new long[]{75000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(122, 1, aMaterial, Materials.Titanium, new long[]{300000L, 128L, 2L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_MV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'B', ItemList.Battery_RE_MV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(124, 1, aMaterial, Materials.TungstenSteel, new long[]{1200000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'B', ItemList.Battery_RE_HV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(120, 1, aMaterial, Materials.StainlessSteel, new long[]{50000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Sodium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(122, 1, aMaterial, Materials.Titanium, new long[]{200000L, 128L, 2L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_MV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Titanium), 'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'B', ItemList.Battery_RE_MV_Sodium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(124, 1, aMaterial, Materials.TungstenSteel, new long[]{800000L, 512L, 3L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXd", "GMG", "PBP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_HV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'B', ItemList.Battery_RE_HV_Sodium.get(1L, new Object[0])});

                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(150, 1, aMaterial, Materials.StainlessSteel, new long[]{100000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PdX", "MGS", "GBP", 'X', OrePrefixes.stickLong.get(aMaterial), 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Lithium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(150, 1, aMaterial, Materials.StainlessSteel, new long[]{75000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PdX", "MGS", "GBP", 'X', OrePrefixes.stickLong.get(aMaterial), 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Cadmium.get(1L, new Object[0])});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(150, 1, aMaterial, Materials.StainlessSteel, new long[]{50000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PdX", "MGS", "GBP", 'X', OrePrefixes.stickLong.get(aMaterial), 'M', ItemList.Electric_Motor_LV.get(1L, new Object[0]), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'B', ItemList.Battery_RE_LV_Sodium.get(1L, new Object[0])});
                if (aSpecialRecipeReq2) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadWrench, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"hXW", "XRX", "WXd", 'X', OrePrefixes.plate.get(aMaterial), 'S', OrePrefixes.plate.get(Materials.Steel), 'R', OrePrefixes.ring.get(Materials.Steel), 'W', OrePrefixes.screw.get(Materials.Steel)});
                break;
            case toolHeadHammer:
            case toolHeadMallet:
                if ((aMaterial != Materials.Stone) && (aMaterial != Materials.Flint)) {
                    GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats((aMaterial.contains(SubTag.BOUNCY)) || (aMaterial.contains(SubTag.WOOD)) ? 14 : 12, 1, aMaterial, aMaterial.mHandleMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                    GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats((aMaterial.contains(SubTag.BOUNCY)) || (aMaterial.contains(SubTag.WOOD)) ? 14 : 12, 1, aMaterial, aMaterial.mHandleMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"XX ", "XXS", "XX ", 'X', aMaterial == Materials.Wood ? OrePrefixes.plank.get(Materials.Wood) : OrePrefixes.ingot.get(aMaterial), 'S', OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                    GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats((aMaterial.contains(SubTag.BOUNCY)) || (aMaterial.contains(SubTag.WOOD)) ? 14 : 12, 1, aMaterial, aMaterial.mHandleMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"XX ", "XXS", "XX ", 'X', aMaterial == Materials.Wood ? OrePrefixes.plank.get(Materials.Wood) : OrePrefixes.gem.get(aMaterial), 'S', OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                }
                if (aPrefix == OrePrefixes.toolHeadHammer)
                    if (aSpecialRecipeReq1) GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadHammer, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"II ", "IIh", "II ", 'P', OrePrefixes.plate.get(aMaterial), 'I', OrePrefixes.ingot.get(aMaterial)});
                break;
            case turbineBlade:
                GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.turbineBlade, aMaterial, 4L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Magnalium, 1L), GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(170, 1, aMaterial, aMaterial, null), 160, 100);
                GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.turbineBlade, aMaterial, 8L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Titanium, 1L), GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(172, 1, aMaterial, aMaterial, null), 320, 400);
                GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.turbineBlade, aMaterial, 12L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 1L), GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(174, 1, aMaterial, aMaterial, null), 640, 1600);
                GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.turbineBlade, aMaterial, 16L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Americium, 1L), GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(176, 1, aMaterial, aMaterial, null), 1280, 6400);
                if (aSpecialRecipeReq2) {
                    GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.turbineBlade, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"fPd", "SPS", " P ", 'P', aMaterial == Materials.Wood ? OrePrefixes.plank.get(aMaterial) : OrePrefixes.plateDouble.get(aMaterial), 'R', OrePrefixes.ring.get(aMaterial), 'S', OrePrefixes.screw.get(aMaterial)});
                }
                break;
        }
    }
}
