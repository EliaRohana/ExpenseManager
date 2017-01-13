/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { MonthlyReportApiService } from './monthly-report-api.service';

describe('MonthlyReportApiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MonthlyReportApiService]
    });
  });

  it('should ...', inject([MonthlyReportApiService], (service: MonthlyReportApiService) => {
    expect(service).toBeTruthy();
  }));
});
