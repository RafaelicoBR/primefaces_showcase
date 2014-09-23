/*
 * Copyright 2009-2014 PrimeTek.
 *
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
package org.primefaces.showcase.view.ajax;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CounterView implements Serializable {
    
    private int number;
    private BasicView basicView;

    public int getNumber() {
        return number;
    }

    public void increment() {
        number++;
        if (number == 110){
        	basicView.setText("");
        }
    }
    
    public static Object getBean(String beanName){
        Object bean = null;
        FacesContext fc = FacesContext.getCurrentInstance();
        if(fc!=null){
             ELContext elContext = fc.getELContext();
             bean = elContext.getELResolver().getValue(elContext, null, beanName);
        }

        return bean;
    }
    
    @PostConstruct
    public void init(){
    	number = 100;
    	basicView = (BasicView) getBean("basicView");
    }
}
