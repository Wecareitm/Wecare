package com.example.wecare.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryInfoVo {

@SerializedName("result")
@Expose
private List<CategoryResultVo> result = null;

public List<CategoryResultVo> getResult() {
return result;
}

public void setResult(List<CategoryResultVo> result) {
this.result = result;
}

}