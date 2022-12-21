package com.andela.telent.assessment.automaticirrigationsystem.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Slf4j
@Service
public class PlotServiceAOP {

    @Pointcut(value = "execution(* com.andela.telent.assessment.automaticirrigationsystem.service.impl.PlotServiceImpl.addPlot(..))")
    public void createPlotPointCut() {
    }

    @Pointcut(value = "execution(* com.andela.telent.assessment.automaticirrigationsystem.service.impl.PlotServiceImpl.configureSensor(..))")
    public void plotConfigurationPointCut() {
    }

    @Pointcut(value = "execution(* com.andela.telent.assessment.automaticirrigationsystem.service.impl.PlotServiceImpl.createSensorSlot(..))")
    public void createSensorSlotPointCut() {
    }

    @Pointcut(value = "execution(* com.andela.telent.assessment.automaticirrigationsystem.events.SensorUnavailableEvent.handlePlotIrrigationSensorSlotEvent(..))")
    public void publishNewSlotPointCut() {
    }

    @After(value = "createPlotPointCut()")
    public void createPlotPointCut(JoinPoint joinPoint) {
        log.info("-----|||REQUEST TO CREATED PLOT COMPLETED {0}|||-----", joinPoint.getArgs());
    }

    @Before(value = "plotConfigurationPointCut()")
    public void plotConfigurationPointCutBefore(JoinPoint joinPoint) {
        log.info("-----|||STARTED PLOT IRRIGATION SENSOR CONFIGURATION {0}|||-----", joinPoint.getArgs());
    }

    @After(value = "plotConfigurationPointCut()")
    public void plotConfigurationPointCutAfter(JoinPoint joinPoint) {
        log.info("-----|||SUCCESSFULLY CREATED PLOT IRRIGATION SENSOR CONFIGURATION {0}|||-----", joinPoint.getArgs());
    }

    @After(value = "createSensorSlotPointCut()")
    public void createSensorSlotPointCutAfter(JoinPoint joinPoint) {
        log.info("-----|||COMPLETED REQUEST TO CREATE SLOT FOR PLOT IRRIGATION SENSOR|||-----", joinPoint.getArgs());
    }

    @Before(value = "publishNewSlotPointCut()")
    public void publishNewSlotPointCutBefore(JoinPoint joinPoint) {
        log.info("-----|||PUBLISH PLOT SLOT TO SENSOR|||-----", joinPoint.getArgs());
    }

    @After(value = "publishNewSlotPointCut()")
    public void publishNewSlotPointCutAfter(JoinPoint joinPoint) {
        log.info("-----|||PLOT'S SENSOR SUCCESSFULLY RECEIVED NEW SLOT|||-----", joinPoint.getArgs());
    }
}
